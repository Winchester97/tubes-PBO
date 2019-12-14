package sistemparkir.controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;
import javax.swing.JOptionPane;
import sistemparkir.view.PengaturanView;
import sistemparkir.model.MobilModel;
import sistemparkir.model.MotorModel;

public class PengaturanController extends MouseAdapter implements ActionListener{
    private final PengaturanView pengaturan;
    private final MotorModel modelPengaturanMotor;
    private final MobilModel modelPengaturanMobil;

    private int xx,xy;
    
    public PengaturanController() {
        this.pengaturan = new PengaturanView();
        this.modelPengaturanMotor = new MotorModel();
        this.modelPengaturanMobil = new MobilModel();
        pengaturan.setLocationRelativeTo(null);
        initView();
        pengaturan.setListener((EventListener) this);
        pengaturan.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        pengaturan.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getActionCommand();
        if (source.equals("Kembali")) {
            pengaturan.dispose();
        }else if (source.equals("Edit Motor")) {
            pengaturan.getjBtnEditMotor().setText("Simpan Motor");
            pengaturan.setEditable("Motor", true);
        }else if (source.equals("Edit Mobil")) {
            pengaturan.getjBtnEditMobil().setText("Simpan Mobil");
            pengaturan.setEditable("Mobil", true);
        }else if (source.equals("Simpan Motor")) {
            String tarifAwalMotor = pengaturan.getjTextTarifAwalMotor().getText();
            String tarifJamMotor = pengaturan.getjTextTarifJamMotor().getText();
            String kapasitasMotor = pengaturan.getjTextKapasitasMotor().getText();

            if (tarifAwalMotor.equals("") || kapasitasMotor.equals("") || tarifJamMotor.equals("")) {
                JOptionPane.showMessageDialog(pengaturan, "Terdapat kolom yang kosong","ERROR",JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    Float tarifAwal = Float.parseFloat(tarifAwalMotor);
                    Float tarifJam = Float.parseFloat(tarifJamMotor);
                    int kapasitas = Integer.parseInt(kapasitasMotor);
                    modelPengaturanMotor.setTarifAwal(tarifAwal);
                    modelPengaturanMotor.setTarifPerJam(tarifJam);
                    modelPengaturanMotor.setKapasitas(kapasitas);
                    pengaturan.getjBtnEditMotor().setText("Edit Motor");
                    pengaturan.setEditable("Motor", false);
                    JOptionPane.showMessageDialog(pengaturan, "Data parkir motor berhasil diubah","SUKSES",JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(pengaturan, "Terdapat Format yang salah !","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if (source.equals("Simpan Mobil")) {
            String tarifAwalMobil = pengaturan.getjTextTarifAwalMobil().getText();
            String tarifJamMobil = pengaturan.getjTextTarifJamMobil().getText();
            String kapasitasMobil = pengaturan.getjTextKapasitasMobil().getText();

            if ("".equals(tarifAwalMobil) || "".equals(kapasitasMobil) || "".equals(tarifJamMobil)) {
                JOptionPane.showMessageDialog(pengaturan, "Terdapat kolom yang kosong","ERROR",JOptionPane.ERROR_MESSAGE);
            }else{
                try {
                    Float tarifAwal = Float.parseFloat(tarifAwalMobil);
                    Float tarifJam = Float.parseFloat(tarifJamMobil);
                    int kapasitas = Integer.parseInt(kapasitasMobil);
                    modelPengaturanMobil.setTarifAwal(tarifAwal);
                    modelPengaturanMobil.setTarifPerJam(tarifJam);
                    modelPengaturanMobil.setKapasitas(kapasitas);
                    pengaturan.getjBtnEditMobil().setText("Edit Mobil");
                    pengaturan.setEditable("Mobil", false);
                    JOptionPane.showMessageDialog(pengaturan, "Data parkir mobil berhasil diubah","SUKSES",JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(pengaturan, "Terdapat Format yang salah !","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }       
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xx = e.getX();
        xy = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        pengaturan.setLocation(x-xx,y-xy);
    }
    
    private void initView(){
        pengaturan.setjTextTarifAwalMotor(modelPengaturanMotor.getTarifAwal());
        pengaturan.setjTextTarifJamMotor(modelPengaturanMotor.getTarifPerJam());
        pengaturan.setjTextKapasitasMotor(modelPengaturanMotor.getKapasitas());
        pengaturan.setjTextTarifAwalMobil(modelPengaturanMobil.getTarifAwal());
        pengaturan.setjTextTarifJamMobil(modelPengaturanMobil.getTarifPerJam());
        pengaturan.setjTextKapasitasMobil(modelPengaturanMobil.getKapasitas());
    }
}
