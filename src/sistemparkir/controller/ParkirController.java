/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import sistemparkir.view.ParkirView;

/**
 *
 * @author 62822
 */
public class ParkirController extends MouseAdapter implements ActionListener{
    private ParkirView parkir = new ParkirView();
    JButton masuk = parkir.getjButtonMasuk();
    JButton keluar = parkir.getjButtonKeluar();    

    public ParkirController() {
        parkir.setLocationRelativeTo(null);
        parkir.setListener(this);
        parkir.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
