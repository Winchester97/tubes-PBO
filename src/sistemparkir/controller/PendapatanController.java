package sistemparkir.controller;

import java.awt.Dialog;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistemparkir.database.DatabaseMySQL;
import sistemparkir.model.PendapatanModel;
import sistemparkir.view.PendapatanView;

public class PendapatanController implements ActionListener{
    private final PendapatanView pendapatan;
    private ArrayList<PendapatanModel> pendapatanArrayList;
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    private final DecimalFormat rupiah;

    
    public PendapatanController() {
        this.pendapatan = new PendapatanView();
        this.rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        pendapatan.setLocationRelativeTo(null);
        pendapatan.setListener(this);
        initView();
        pendapatan.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        pendapatan.setVisible(true);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getActionCommand();
        if (source.equals("OK")) {
            DefaultTableModel table = (DefaultTableModel) pendapatan.getjTableBulan().getModel();
            int rowCount = table.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                table.removeRow(i);
            }
            tampil_bulanan();
        }
    }
    
    private void initView(){
        int tahun = Calendar.getInstance().get(Calendar.YEAR);
        int bulan = Calendar.getInstance().get(Calendar.MONTH);
        for (int i = tahun; i > 2008; i--) {
            pendapatan.getjComboTahun().addItem(""+i);
        }
        pendapatan.getjComboTahun().setSelectedItem(""+tahun);
        pendapatan.getjComboBulan().setSelectedIndex(bulan);
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        rupiah.setDecimalFormatSymbols(formatRp);
        tampil_harian();
        tampil_bulanan();
        
    }
    
    private void tampil_harian(){   
        ArrayList<PendapatanModel> PendapatanArrayList = getData("harian");
        if (PendapatanArrayList == null) {
            JOptionPane.showMessageDialog(pendapatan, "Hari ini belum ada pendapatan masuk"); 
        }else{
            setData(PendapatanArrayList, "harian");
        }
    }
    
    private void tampil_bulanan(){
        String bln = pendapatan.getjComboBulan().getSelectedItem().toString();
        String th = pendapatan.getjComboTahun().getSelectedItem().toString();       
        ArrayList<PendapatanModel> PendapatanArrayList = getData("bulanan");
        if (PendapatanArrayList == null) {
            JOptionPane.showMessageDialog(pendapatan, "Data pendaptan bulan "+bln+" tahun "+th+" kosong!"); 
            pendapatan.getjTextFieldPdptnBulan().setText("");
        }else{
            setData(PendapatanArrayList, "bulanan");
        }            
    }
    
    private ArrayList<PendapatanModel> getData(String tipe){
        String query;
        if (tipe.equals("harian")) {
            query = "SELECT *, from_unixtime(waktu_keluar / 1000, '%y-%m-%d')"
                    + " hari_ini FROM parkir_keluar HAVING from_unixtime(waktu_keluar / 1000, '%y-%m-%d')"
                    + " = UTC_DATE()";            
        }else{
            int bulan = pendapatan.getjComboBulan().getSelectedIndex()+1;
            String th = pendapatan.getjComboTahun().getSelectedItem().toString();
            int tahun = Integer.parseInt(th);           
            query = "SELECT *, from_unixtime(waktu_keluar / 1000, '%y-%m')"
                    + " hari_ini FROM parkir_keluar HAVING from_unixtime(waktu_keluar / 1000, '%y-%m')"
                    + " = '"+(tahun-2000)+"-"+bulan+"'";            
        }
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            rs = st.executeQuery(query);
            PendapatanModel dataPendapatan;
            pendapatanArrayList = new ArrayList<>();
            int i = 0;
            while (rs.next()) {
                i++;
                String no_tiket = rs.getString("no_tiket");
                String no_polisi = rs.getString("no_polisi");
                String tgl_keluar = new SimpleDateFormat("dd-MM-yyyy").format(new Date(rs.getLong("waktu_keluar")));
                String biaya = rupiah.format(rs.getInt("biaya"));
                dataPendapatan = new PendapatanModel(no_tiket, no_polisi, tgl_keluar, biaya);
                pendapatanArrayList.add(dataPendapatan);
            }
            if (i == 0) {
                return null;
            }else{
                return pendapatanArrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    
    }
    
    private void setData(ArrayList<PendapatanModel> pendapatanArray, String tipe){
        String query;
        JTextField totalpendapatan;
        DefaultTableModel dataTable;
        JTable table;
        if (tipe.equals("harian")) {
            query = "SELECT SUM(biaya) total_biaya from parkir_keluar where from_unixtime(waktu_keluar / 1000, '%y-%m-%d') = UTC_DATE()";
            totalpendapatan = pendapatan.getjTextPdptnHari();
            dataTable = (DefaultTableModel) pendapatan.getTabelHari().getModel();
            table = pendapatan.getTabelHari();
        }else {
            int bulan = pendapatan.getjComboBulan().getSelectedIndex()+1;
            String th = pendapatan.getjComboTahun().getSelectedItem().toString();
            int tahun = Integer.parseInt(th);            
            query = "SELECT SUM(biaya) total_biaya from parkir_keluar where from_unixtime(waktu_keluar / 1000, '%y-%m') = '"+(tahun-2000)+"-"+bulan+"'";
            totalpendapatan = pendapatan.getjTextFieldPdptnBulan();
            dataTable = (DefaultTableModel) pendapatan.getjTableBulan().getModel();
            table = pendapatan.getjTableBulan();
        }
        pendapatanArray.stream().map((p) -> {
        String no_tiket = p.getNo_tiket();
        String no_polisi = p.getNo_polisi();
        String tgl_keluar = p.getTgl_keluar();
        String biaya = p.getBiaya();
        String [] data = {no_tiket,no_polisi,tgl_keluar,biaya};
        return data;
        }).forEachOrdered((data) -> {
            dataTable.addRow(data);
        });
        table.setModel(dataTable);
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) { 
                String biaya = rs.getString("total_biaya");
                long biaya2 = Long.parseLong(biaya);
                biaya = rupiah.format(biaya2);
                totalpendapatan.setText(biaya);
            }
        } catch (Exception e) {
        }
    }
    
    
}
