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
import java.util.Calendar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import sistemparkir.database.DatabaseMySQL;
import sistemparkir.view.PendapatanView;

/**
 *
 * @author 62822
 */
public class PendapatanController implements ActionListener{
    PendapatanView pendapatan = new PendapatanView();
    DefaultTableModel harian,bulanan;
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    
    public PendapatanController() {
        pendapatan.setLocationRelativeTo(null);
        pendapatan.setListener(this);
        pendapatan.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initView();
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
            String query = "SELECT * FROM parkir_keluar";
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
        } catch (Exception e) {
        }
        
    }
}
