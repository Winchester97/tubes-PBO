/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.model;
import java.sql.*;
import sistemparkir.database.DatabaseMySQL;
/**
 *
 * @author 62822
 */
public class MotorModel implements pengaturan{
    Connection konek;
    Statement st;
    ResultSet rs;
    
    @Override
    public Float getTarifAwal() {
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            String query = "SELECT tarif_awal_motor FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                System.out.println("ada");
                return rs.getFloat("tarif_awal_motor");
            }else{
                System.out.println("Kosong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Float getTarifPerJam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getKapasitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTarifAwal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTarifPerJam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKapasitas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
