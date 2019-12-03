/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sistemparkir.view.PengaturanView;

/**
 *
 * @author 62822
 */
public class PengaturanController extends MouseAdapter implements ActionListener{
    private PengaturanView pengaturan = new PengaturanView();
    private JFrame dashboard;
    private int xx,xy;
    
    public PengaturanController(JFrame dashboard) {
        this.dashboard = dashboard;
        pengaturan.setLocationRelativeTo(null);
        pengaturan.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pengaturan.setListener((EventListener) this);
        pengaturan.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        pengaturan.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(pengaturan.getjButtonKembali())) {
            pengaturan.dispose();
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
    
}
