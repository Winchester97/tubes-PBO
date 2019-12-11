package sistemparkir.model;
import java.sql.*;
import sistemparkir.database.DatabaseMySQL;
/**
 *
 * @author Ammar Amri
 */
public class MotorModel implements pengaturan{
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    
    @Override
    public Float getTarifAwal() {
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            String query = "SELECT tarif_awal_motor FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getFloat("tarif_awal_motor");
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
            String query = "SELECT tarif_jam_motor FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getFloat("tarif_jam_motor");
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
            String query = "SELECT kapasitas_motor FROM pengaturan";
            rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("kapasitas_motor");
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
            String query = "UPDATE pengaturan SET tarif_awal_motor=?";
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
            String query = "UPDATE pengaturan SET tarif_jam_motor=?";
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
            String query = "UPDATE pengaturan SET kapasitas_motor=?";
            PreparedStatement ps = konek.prepareStatement(query);
            ps.setInt(1, kapasitas);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    
    
}
