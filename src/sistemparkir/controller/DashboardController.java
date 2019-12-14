package sistemparkir.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sistemparkir.database.DatabaseMySQL;
import sistemparkir.view.DashboardView;

public class DashboardController extends MouseAdapter{
    private ParkirController parkirController;
    private PendapatanController pendapatanController;
    private PengaturanController pengaturanController;
    private final DashboardView dashboard;
    private final JPanel parkir;
    private final JPanel pendapatan;
    private final JPanel pengaturan;
    private final JPanel keluar;
    private final JPanel topPanel;
    private int xx,xy;

    public DashboardController() {
        this.dashboard = new DashboardView();
        this.parkir = dashboard.getParkir();
        this.pendapatan = dashboard.getPendapatan();
        this.pengaturan = dashboard.getPengaturan();
        this.keluar = dashboard.getKeluar();
        this.topPanel = dashboard.getTopPanel();
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
        }else if (source.equals(keluar)){
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
            int dialogBtn = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(dashboard, "Anda yakin akan keluar?", "PERINGATAN", dialogBtn);
            if (dialogResult == 0) {
                System.exit(0);
            }
        }else if (source.equals(topPanel)) {
            xx = e.getX();
            xy = e.getY();
        }else if (source.equals(pengaturan)) {
            if (!DatabaseMySQL.isConnect()) {
                JOptionPane.showMessageDialog(dashboard, "Gagal Terkoneksi dengan database","DATABASE FAILED",JOptionPane.ERROR_MESSAGE);
            }else{
                pengaturanController = new PengaturanController();
            }
        }else if (source.equals(parkir)) {
            parkirController = new ParkirController();
        }else if (source.equals(pendapatan)) {
            if (!DatabaseMySQL.isConnect()) {
                JOptionPane.showMessageDialog(dashboard, "Gagal Terkoneksi dengan database","DATABASE FAILED",JOptionPane.ERROR_MESSAGE);
            }else{
                pendapatanController = new PendapatanController();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        dashboard.setLocation(x-xx,y-xy);
    }   
}
