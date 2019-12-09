/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import sistemparkir.model.ParkirModel;
import sistemparkir.view.ParkirView;

/**
 *
 * @author 62822
 */
public class ParkirController extends MouseAdapter implements ActionListener{
    private ParkirView parkir = new ParkirView();
    private ParkirModel parkirModel = new ParkirModel();
    private JButton masuk = parkir.getjButtonMasuk();
    private JButton keluar = parkir.getjButtonKeluar();    
    JTextField noPolMasuk = parkir.getNoPolMasuk();
    JRadioButton motor = parkir.getMotor();
    JRadioButton mobil = parkir.getMobil();
    DefaultTableModel tabelMasuk,tabelKeluar;
    String [] data;
    
    public ParkirController() {
        parkir.setLocationRelativeTo(null);
        parkir.setListener(this);
        parkir.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tampilTabelMasuk();
        tampilTabelKeluar();
        parkir.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getActionCommand();
        if (source.equals("MASUK")) {
            parkir.getKeluarPane().setVisible(false);
            parkir.getMasukPane().setVisible(true);
        }else if (source.equals("KELUAR")) {
            parkir.getMasukPane().setVisible(false);
            parkir.getKeluarPane().setVisible(true);
        }else if (source.equals("Simpan")) {
            if (noPolMasuk.getText().isEmpty()) {
                JOptionPane.showMessageDialog(parkir, "No polisi belum diisi","Gagal",JOptionPane.ERROR_MESSAGE);
            }else if (!motor.isSelected() && !mobil.isSelected()) {
                JOptionPane.showMessageDialog(parkir, "Jenis kendaraan belum dipilih","Gagal",JOptionPane.ERROR_MESSAGE);   
            }else{
                if (motor.isSelected()) {
                    if (parkirModel.parkirMasuk(noPolMasuk.getText(), "Motor")){
                        JOptionPane.showMessageDialog(parkir, "Data Berhasil disimpan");
                    }else{
                        JOptionPane.showMessageDialog(parkir, "Data gagal disimpan");
                    }
                } else if (mobil.isSelected()) {
                    if (parkirModel.parkirMasuk(noPolMasuk.getText(), "Mobil")){
                        JOptionPane.showMessageDialog(parkir, "Data Berhasil disimpan");
                    }else{
                        JOptionPane.showMessageDialog(parkir, "Data gagal disimpan");
                    }                    
                }
                resetMasuk();
                tampilTabelMasuk();
            }
        } else if (source.equals("CARI")) {
            if (parkir.getCariKeluar().getText().isEmpty()) {
                JOptionPane.showMessageDialog(parkir, "No. Tiket / No. Pol belum di input","Gagal",JOptionPane.ERROR_MESSAGE);
            } 
            else {
                data = parkirModel.ValidasiCari(parkir.getCariKeluar().getText());
                if (data == null){
                    JOptionPane.showMessageDialog(parkir, "no. Polisi / no. Tiket Tidak ada","Gagal",JOptionPane.ERROR_MESSAGE);
                } else {
                    parkir.getjTextNoTiket().setText(data[0]);
                    parkir.getjTextNopol().setText(data[1]);
                    parkir.getjTextJenis().setText(data[2]);
                    parkir.getjTextTglJamMasuk().setText(data[4]+" / "+data[3]);
                    parkir.getjTextDurasi().setText(data[5]);
                    parkir.getjTextBiaya().setText(data[6]);
                    parkir.getjBtnParkirKeluar().setEnabled(true);
                    parkir.getjBtnBersihkan().setEnabled(true);
                }
            }
        } else if (source.equals("Bersihkan")) {
            resetKeluar();
            tampilTabelKeluar();
            parkir.getjBtnBersihkan().setEnabled(false);
            parkir.getjBtnParkirKeluar().setEnabled(false);
        } else if (source.equals("Parkir Keluar")) {
            if (parkirModel.parkirKeluar(data)) {
                JOptionPane.showMessageDialog(parkir, parkir.getjTextJenis().getText()
                + " Dengan Plat no. " +parkir.getjTextNopol().getText()+ " Berhasil Keluar" + " ");
                parkirModel.hapusMasuk(parkir.getjTextNoTiket().getText());   
                parkir.getjBtnBersihkan().setEnabled(false);
                parkir.getjBtnParkirKeluar().setEnabled(false);
            }else{
                System.out.println("Gagal");
            }
            resetKeluar();
            tampilTabelKeluar();
            resetMasuk();
            tampilTabelMasuk();
        }
    }
    
    private void resetMasuk(){
        noPolMasuk.setText("");
        motor.setSelected(false);
        mobil.setSelected(false);
        int rowCount = tabelMasuk.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelMasuk.removeRow(i);
        }
    }
    
    private void resetKeluar(){
        parkir.getCariKeluar().setText("");
        parkir.getjTextNoTiket().setText("");
        parkir.getjTextNopol().setText("");
        parkir.getjTextJenis().setText("");
        parkir.getjTextTglJamMasuk().setText("");
        parkir.getjTextDurasi().setText("");
        parkir.getjTextBiaya().setText("");
        int rowCount = tabelKeluar.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKeluar.removeRow(i);
        }
    }
    
    private void tampilTabelMasuk(){
        tabelMasuk = parkirModel.setTabelMasuk((DefaultTableModel) parkir.getTableMasuk().getModel());
        if (tabelMasuk != null) {
            parkir.getTableMasuk().setModel(tabelMasuk);
        }
    }
    
    private void tampilTabelKeluar() {
        tabelKeluar = parkirModel.setTabelKeluar((DefaultTableModel) parkir.getTableKeluar().getModel());
        if (tabelKeluar != null) {
            parkir.getTableKeluar().setModel(tabelKeluar);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(masuk)) {
            parkir.setColor(masuk);
        }else if (source.equals(keluar)) {
            parkir.setColor(keluar);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(masuk)) {
            parkir.resetColor(masuk);
        }else if (source.equals(keluar)) {
            parkir.resetColor(keluar);
        }
    }
    
        
}
