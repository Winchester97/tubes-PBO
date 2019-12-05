/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.model;

/**
 *
 * @author 62822
 */
public interface pengaturan {
    
    public Float getTarifAwal();
    
    public Float getTarifPerJam();
    
    public int getKapasitas();
    
    public void setTarifAwal(Float tarifAwal);
    
    public void setTarifPerJam(Float tarifJam);
    
    public void setKapasitas(int kapasitas);
    
}
