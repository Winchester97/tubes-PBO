/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import sistemparkir.view.DashboardView;

/**
 *
 * @author 62822
 */
public class DashboardController extends MouseAdapter{
    private DashboardView dashboard = new DashboardView();
    private JPanel parkir = dashboard.getParkir();
    private JPanel pendapatan = dashboard.getPendapatan();
    private JPanel pengaturan = dashboard.getPengaturan();
    private JPanel keluar = dashboard.getKeluar();

    public DashboardController() {
        dashboard.setLocationRelativeTo(null);
        dashboard.setListener(this);
        dashboard.setVisible(true);
    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(parkir)) {
            dashboard.setColor(parkir);
        }else if (source.equals(pendapatan)) {
            dashboard.setColor(pendapatan);
        }else if (source.equals(pengaturan)) {
            dashboard.setColor(pengaturan);
        }else{
            dashboard.setColor(keluar);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(parkir)) {
            dashboard.resetColor(parkir);
        }else if (source.equals(pendapatan)) {
            dashboard.resetColor(pendapatan);
        }else if (source.equals(pengaturan)) {
            dashboard.resetColor(pengaturan);
        }else{
            dashboard.resetColor(keluar);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(keluar)) {
            System.exit(0);
        }
    }
    
    
    
}
