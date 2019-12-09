/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import sistemparkir.database.DatabaseMySQL;
import sistemparkir.model.PendapatanModel;
import sistemparkir.view.PendapatanView;

/**
 *
 * @author 62822
 */
public class PendapatanController implements ActionListener{
    private PendapatanView pendapatan = new PendapatanView();
    private DefaultTableModel harian,bulanan;
    private ArrayList<PendapatanModel> pendapatanArrayList;
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    
    public PendapatanController() {
        pendapatan.setLocationRelativeTo(null);
        pendapatan.setListener(this);
        pendapatan.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initView();
        tampil_harian();
        pendapatan.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
    }
    
    private void initView(){
        int tahun = Calendar.getInstance().get(Calendar.YEAR);
        int bulan = Calendar.getInstance().get(Calendar.MONTH);
        for (int i = tahun; i > 2008; i--) {
            pendapatan.getjComboTahun().addItem(""+i);
        }
        pendapatan.getjComboTahun().setSelectedItem(""+tahun);
        pendapatan.getjComboBulan().setSelectedIndex(bulan);
        
    }
    
    private void tampil_harian(){
        DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        rupiah.setDecimalFormatSymbols(formatRp);   
        
        harian = (DefaultTableModel) pendapatan.getTabelHari().getModel();
        try {
            String query = "SELECT *, from_unixtime(waktu_keluar / 1000, '%y-%m-%d')"
                    + " hari_ini FROM parkir_keluar HAVING from_unixtime(waktu_keluar / 1000, '%y-%m-%d')"
                    + " = UTC_DATE()";
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            rs = st.executeQuery(query);
            Long totalpdptn;
            PendapatanModel pendapatanHarian;
            pendapatanArrayList = new ArrayList<PendapatanModel>();
            int i = 0;
            while (rs.next()) {
                i++;
                int idKeluar = rs.getInt("id_keluar");
                String no_tiket = rs.getString("no_tiket");
                String no_polisi = rs.getString("no_polisi");
                String tgl_keluar = new SimpleDateFormat("dd-MM-yyyy").format(new Date(rs.getLong("waktu_keluar")));
                String biaya = rupiah.format(rs.getInt("biaya"));
                pendapatanHarian = new PendapatanModel(no_tiket, no_polisi, tgl_keluar, biaya);
                pendapatanArrayList.add(pendapatanHarian);
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(pendapatan, "Hari ini belum ada pendapatan masuk"); 
            }else{
                DefaultTableModel hari_table = (DefaultTableModel) pendapatan.getTabelHari().getModel();
                pendapatanArrayList.stream().map((p) -> {
                    String no_tiket = p.getNo_tiket();
                    String no_polisi = p.getNo_polisi();
                    String tgl_keluar = p.getTgl_keluar();
                    String biaya = p.getBiaya();
                    String [] data = {no_tiket,no_polisi,tgl_keluar,biaya};
                    return data;
                }).forEachOrdered((data) -> {
                    hari_table.addRow(data);
                });
                pendapatan.getTabelHari().setModel(hari_table);
                try {
                    st = konek.createStatement();
                    query = "SELECT SUM(biaya) total_biaya from parkir_keluar where from_unixtime(waktu_keluar / 1000, '%y-%m-%d') = UTC_DATE()";
                    rs = st.executeQuery(query);
                    while (rs.next()) {                        
                        String biaya = rs.getString("total_biaya");
                        long biaya2 = Long.parseLong(biaya);
                        biaya = rupiah.format(biaya2);
                        pendapatan.getjTextPdptnHari().setText(biaya);
                    }
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
