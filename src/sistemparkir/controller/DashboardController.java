/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.controller;

import sistemparkir.view.DashboardView;

/**
 *
 * @author 62822
 */
public class DashboardController {
    private DashboardView dashboard = new DashboardView();

    public DashboardController() {
        dashboard.setLocationRelativeTo(null);
        dashboard.setTitle("Sistem Parkir");
        dashboard.setVisible(true);
    }
    
    
}
