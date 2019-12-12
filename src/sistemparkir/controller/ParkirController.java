package sistemparkir.controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sistemparkir.model.ParkirModel;
import sistemparkir.view.ParkirView;

/**
 *
 * @author Ammar Amri
 */
public class ParkirController extends MouseAdapter implements ActionListener{
    private ParkirView parkirView;
    private ParkirModel parkirModel;
    private JButton masukBtn;
    private JButton keluarBtn;    
    private JTextField jTxtFieldnoPolMasuk;
    private JRadioButton jRadioBtnMtr;
    private JRadioButton jRadioBtnMbl;
    private DefaultTableModel tabelMasuk,tabelKeluar;
    private String [] data;
    private int jumlahMtr;
    private int jumlahMbl;
    private int kapasitasMtr;
    private int kapasitasMbl;
    
    public ParkirController() {
        this.parkirView = new ParkirView();
        this.parkirModel = new ParkirModel();
        this.masukBtn = parkirView.getjButtonMasuk();
        this.keluarBtn = parkirView.getjButtonKeluar();
        this.jTxtFieldnoPolMasuk = parkirView.getNoPolMasuk();
        this.jRadioBtnMtr = parkirView.getMotor();
        this.jRadioBtnMbl = parkirView.getMobil();
        parkirView.setLocationRelativeTo(null);
        parkirView.setListener(this);
        parkirView.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        tampilTabelMasuk();
        tampilTabelKeluar();
        cekKapasitas();
        parkirView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getActionCommand();
        if (source.equals("MASUK")) {
            parkirView.getKeluarPane().setVisible(false);
            parkirView.getMasukPane().setVisible(true);
        }else if (source.equals("KELUAR")) {
            parkirView.getMasukPane().setVisible(false);
            parkirView.getKeluarPane().setVisible(true);
        }else if (source.equals("Simpan")) {
            if (jTxtFieldnoPolMasuk.getText().isEmpty()) {
                JOptionPane.showMessageDialog(parkirView, "No polisi belum diisi","Gagal",JOptionPane.ERROR_MESSAGE);
            }else if (!jRadioBtnMtr.isSelected() && !jRadioBtnMbl.isSelected()) {
                JOptionPane.showMessageDialog(parkirView, "Jenis kendaraan belum dipilih","Gagal",JOptionPane.ERROR_MESSAGE);   
            }else{
                if (jRadioBtnMtr.isSelected()) {
                    if (parkirModel.parkirMasuk(jTxtFieldnoPolMasuk.getText(), "Motor")){
                        JOptionPane.showMessageDialog(parkirView, "Data Berhasil disimpan");
                    }else{
                        JOptionPane.showMessageDialog(parkirView, "Data gagal disimpan");
                    }
                } else if (jRadioBtnMbl.isSelected()) {
                    if (parkirModel.parkirMasuk(jTxtFieldnoPolMasuk.getText(), "Mobil")){
                        JOptionPane.showMessageDialog(parkirView, "Data Berhasil disimpan");
                    }else{
                        JOptionPane.showMessageDialog(parkirView, "Data gagal disimpan");
                    }                    
                }
                resetMasuk();
                tampilTabelMasuk();
                cekKapasitas();
            }
        } else if (source.equals("CARI")) {
            if (parkirView.getCariKeluar().getText().isEmpty()) {
                JOptionPane.showMessageDialog(parkirView, "No. Tiket / No. Pol belum di input","Gagal",JOptionPane.ERROR_MESSAGE);
            } 
            else {
                data = parkirModel.ValidasiCari(parkirView.getCariKeluar().getText());
                if (data == null){
                    JOptionPane.showMessageDialog(parkirView, "no. Polisi / no. Tiket Tidak ada","Gagal",JOptionPane.ERROR_MESSAGE);
                    resetKeluar();
                    tampilTabelKeluar();
                } else {
                    parkirView.getjTextNoTiket().setText(data[0]);
                    parkirView.getjTextNopol().setText(data[1]);
                    parkirView.getjTextJenis().setText(data[2]);
                    parkirView.getjTextTglJamMasuk().setText(data[4]+" / "+data[3]);
                    parkirView.getjTextDurasi().setText(data[5]);
                    parkirView.getjTextBiaya().setText(data[6]);
                    parkirView.getjBtnParkirKeluar().setEnabled(true);
                    parkirView.getjBtnBersihkan().setEnabled(true);
                }
            }
        } else if (source.equals("Bersihkan")) {
            resetKeluar();
            tampilTabelKeluar();
            parkirView.getjBtnBersihkan().setEnabled(false);
            parkirView.getjBtnParkirKeluar().setEnabled(false);
        } else if (source.equals("Parkir Keluar")) {
            if (parkirModel.parkirKeluar(data)) {
                JOptionPane.showMessageDialog(parkirView, parkirView.getjTextJenis().getText()
                + " Dengan Plat no. " +parkirView.getjTextNopol().getText()+ " Berhasil Keluar" + " ");
                parkirModel.hapusMasuk(parkirView.getjTextNoTiket().getText());   
            }else{
                System.out.println("Gagal");
            }
            resetKeluar();
            tampilTabelKeluar();
            resetMasuk();
            tampilTabelMasuk();
            cekKapasitas();
        }
    }
    
    private void resetMasuk(){
        jTxtFieldnoPolMasuk.setText("");
        jRadioBtnMtr.setSelected(false);
        jRadioBtnMbl.setSelected(false);
        int rowCount = tabelMasuk.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelMasuk.removeRow(i);
        }
    }
    
    private void resetKeluar(){
        parkirView.getCariKeluar().setText("");
        parkirView.getjTextNoTiket().setText("");
        parkirView.getjTextNopol().setText("");
        parkirView.getjTextJenis().setText("");
        parkirView.getjTextTglJamMasuk().setText("");
        parkirView.getjTextDurasi().setText("");
        parkirView.getjTextBiaya().setText("");
        int rowCount = tabelKeluar.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tabelKeluar.removeRow(i);
        }
        parkirView.getjBtnBersihkan().setEnabled(false);
        parkirView.getjBtnParkirKeluar().setEnabled(false);
    }
    
    private void tampilTabelMasuk(){
        tabelMasuk = parkirModel.setTabelMasuk((DefaultTableModel) parkirView.getTableMasuk().getModel());
        if (tabelMasuk != null) {
            parkirView.getTableMasuk().setModel(tabelMasuk);
        }
    }
    
    private void tampilTabelKeluar() {
        tabelKeluar = parkirModel.setTabelKeluar((DefaultTableModel) parkirView.getTableKeluar().getModel());
        if (tabelKeluar != null) {
            parkirView.getTableKeluar().setModel(tabelKeluar);
        }
    }
    
    private void cekKapasitas(){
        this.jumlahMtr = parkirModel.getJumlahMotor();
        this.jumlahMbl = parkirModel.getJumlahMobil();
        this.kapasitasMtr = parkirModel.getKapasitasMotor();
        this.kapasitasMbl = parkirModel.getKapasitasMobil();
        parkirView.getjTextFieldKptsMtr().setText(String.valueOf(kapasitasMtr));
        parkirView.getjTextFieldKpstsMbl().setText(String.valueOf(kapasitasMbl));
        parkirView.getjTextFieldJmlMtr().setText(String.valueOf(jumlahMtr));
        parkirView.getjTextFieldJmlMbl().setText(String.valueOf(jumlahMbl));
        JLabel notif = parkirView.getjLabelNotif();
        if (jumlahMtr>=kapasitasMtr && jumlahMbl>=kapasitasMbl) {
            JOptionPane.showMessageDialog(parkirView, "Kapasitas Motor dan Mobil Penuh !");
            jRadioBtnMtr.setEnabled(false);
            jRadioBtnMbl.setEnabled(false);
            jTxtFieldnoPolMasuk.setEnabled(false);
            parkirView.getSimpanMasuk().setEnabled(false);
        }else if (jumlahMtr>=kapasitasMtr) {
            notif.setText("Kapasitas Motor Penuh !");
            jRadioBtnMtr.setEnabled(false);
            jRadioBtnMbl.setSelected(true);
        }else if (jumlahMbl>=kapasitasMbl) {
            notif.setText("Kapasitas Mobil Penuh !");
            jRadioBtnMbl.setEnabled(false);
            jRadioBtnMtr.setSelected(true);
        }else{
            notif.setText("");
            jRadioBtnMbl.setEnabled(true);
            jRadioBtnMtr.setEnabled(true);
            jTxtFieldnoPolMasuk.setEnabled(true);
            parkirView.getSimpanMasuk().setEnabled(true);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(masukBtn)) {
            parkirView.setColor(masukBtn);
        }else if (source.equals(keluarBtn)) {
            parkirView.setColor(keluarBtn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(masukBtn)) {
            parkirView.resetColor(masukBtn);
        }else if (source.equals(keluarBtn)) {
            parkirView.resetColor(keluarBtn);
        }
    }
    
        
}
