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
public class MobilModel implements pengaturan{
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    
    @Override
    public Float getTarifAwal() {
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            String query = "SELECT tarif_awal_mobil FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getFloat("tarif_awal_mobil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Float getTarifPerJam() {
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            String query = "SELECT tarif_jam_mobil FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getFloat("tarif_jam_mobil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getKapasitas() {
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            String query = "SELECT kapasitas_mobil FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("kapasitas_mobil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void setTarifAwal(Float tarifAwal) {
         try {
            konek = DatabaseMySQL.getConnection(); 
            String query = "UPDATE pengaturan SET tarif_awal_mobil=?";
            PreparedStatement ps = konek.prepareStatement(query);
            ps.setFloat(1, tarifAwal);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }

    @Override
    public void setTarifPerJam(Float tarifJam) {
         try {
            konek = DatabaseMySQL.getConnection(); 
            String query = "UPDATE pengaturan SET tarif_jam_mobil=?";
            PreparedStatement ps = konek.prepareStatement(query);
            ps.setFloat(1, tarifJam);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void setKapasitas(int kapasitas) {
         try {
            konek = DatabaseMySQL.getConnection(); 
            String query = "UPDATE pengaturan SET kapasitas_mobil=?";
            PreparedStatement ps = konek.prepareStatement(query);
            ps.setInt(1, kapasitas);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


}
