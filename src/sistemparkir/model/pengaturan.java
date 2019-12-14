package sistemparkir.model;

public interface pengaturan {
    
    public Float getTarifAwal();
    
    public Float getTarifPerJam();
    
    public int getKapasitas();
    
    public void setTarifAwal(Float tarifAwal);
    
    public void setTarifPerJam(Float tarifJam);
    
    public void setKapasitas(int kapasitas);
    
}
