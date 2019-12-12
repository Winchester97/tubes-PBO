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

/**
 *
 * @author Ammar Amri
 */
public class PengaturanController extends MouseAdapter implements ActionListener{
    private PengaturanView pengaturan = new PengaturanView();
    private MotorModel modelPengaturanMotor = new MotorModel();
    private MobilModel modelPengaturanMobil = new MobilModel();

    private int xx,xy;
    
    public PengaturanController() {
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
            Float tarifAwalMotor = pengaturan.getjTextTarifAwalMotor();
            Float tarifJamMotor = pengaturan.getjTextTarifJamMotor();
            int kapasitasMotor = pengaturan.getjTextKapasitasMotor();

            if (tarifAwalMotor == null || kapasitasMotor == 0 || tarifJamMotor == null) {
                JOptionPane.showMessageDialog(pengaturan, "Terdapat kolom yang kosong","ERROR",JOptionPane.ERROR_MESSAGE);
            }else{
                modelPengaturanMotor.setTarifAwal(tarifAwalMotor);
                modelPengaturanMotor.setTarifPerJam(tarifJamMotor);
                modelPengaturanMotor.setKapasitas(kapasitasMotor);
                pengaturan.getjBtnEditMotor().setText("Edit Motor");
                pengaturan.setEditable("Motor", false);
            }
        }else if (source.equals("Simpan Mobil")) {
            Float tarifAwalMobil = pengaturan.getjTextTarifAwalMobil();
            Float tarifJamMobil = pengaturan.getjTextTarifJamMobil();
            int kapasitasMobil = pengaturan.getjTextKapasitasMobil();

            if (tarifAwalMobil == null || kapasitasMobil == 0 || tarifJamMobil == null) {
                JOptionPane.showMessageDialog(pengaturan, "Terdapat kolom yang kosong","ERROR",JOptionPane.ERROR_MESSAGE);
            }else{
                modelPengaturanMobil.setTarifAwal(tarifAwalMobil);
                modelPengaturanMobil.setTarifPerJam(tarifJamMobil);
                modelPengaturanMobil.setKapasitas(kapasitasMobil);
                pengaturan.getjBtnEditMobil().setText("Edit Mobil");
                pengaturan.setEditable("Mobil", false);
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
