/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkir.model;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.table.DefaultTableModel;
import sistemparkir.database.DatabaseMySQL;
/**
 *
 * @author 62822
 */
public class ParkirModel {
    private Connection konek;
    private Statement st;
    private ResultSet rs;
    private MotorModel motor = new MotorModel();
    private MobilModel mobil = new MobilModel();
    
    public boolean parkirMasuk(String nopol, String jenis){
        String sql = "INSERT INTO parkir_masuk(no_polisi,jenis_kendaraan,jam_masuk,tgl_masuk)"
                    + "VALUES('"+nopol+"','"+jenis+"',CURTIME(),CURDATE())";
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            st.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public DefaultTableModel setTabelMasuk(DefaultTableModel masuk){
        String query = "SELECT * FROM parkir_masuk ORDER BY no_tiket ASC";        
        try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {                
                String no_tiket = rs.getString("no_tiket");
                String no_pol = rs.getString("no_polisi");
                String jenis = rs.getString("jenis_kendaraan");
                String jam_masuk = rs.getString("jam_masuk");
                String tgl_masuk = rs.getString("tgl_masuk");
                
                String [] data = {no_tiket, no_pol, jenis, jam_masuk, tgl_masuk};
                masuk.addRow(data);
            }
            return masuk;
        } catch (Exception e) {
            return null;
        }
    }
    
   public String[] ValidasiCari (String Cari) {
       DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
       DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
       formatRp.setCurrencySymbol("Rp ");
       formatRp.setMonetaryDecimalSeparator(',');
       formatRp.setGroupingSeparator('.');
       rupiah.setDecimalFormatSymbols(formatRp);
       String query = "SELECT *, DATEDIFF(CURDATE(), tgl_masuk) durasi_hari, (TIMEDIFF(CURTIME(),jam_masuk)) durasi_jam "
                    + "FROM parkir_masuk WHERE no_polisi='"+Cari+"' OR no_tiket='"+Cari+"'";
//       
//       "SELECT *, DATEDIFF(CURDATE(), tgl_masuk) durasi_hari, (TIME_FORMAT(CURTIME(),'%H')-TIME_FORMAT(jam_masuk, '%H')) durasi_jam "
//                    + "FROM tb_parkir WHERE no_pol='"+txtKNoPol.getText()+"' AND biaya=0";
       
       try {
            konek = DatabaseMySQL.getConnection();
            st = konek.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                String no_tiket = rs.getString("no_tiket");
                System.out.println("gagal 1");
                String no_pol = rs.getString("no_polisi");
                String jenis = rs.getString("jenis_kendaraan");
                String jam_masuk = rs.getString("jam_masuk");
                int menit = toMins(rs.getString("durasi_jam"));
                int durasi_jam = menit / 60;
                if ((menit % 60) > 0) {
                    durasi_jam++;
                }
                String tgl_masuk = rs.getString("tgl_masuk");
                int durasi_hari = Integer.parseInt(rs.getString("durasi_hari"));
                String durasi;
                int biaya_jam, biaya_hari, biaya_awal;
                String biaya_akhir;
                if (rs.getString("jenis_kendaraan") == "Mobil"){
                    biaya_jam = mobil.getTarifPerJam().intValue();
                    biaya_awal = mobil.getTarifAwal().intValue();
                    biaya_hari = 50000;
                }else{
                    biaya_jam = motor.getTarifPerJam().intValue();
                    biaya_awal = motor.getTarifAwal().intValue();
                    biaya_hari = 20000;
                }
                if (durasi_hari > 0) {
                    durasi = durasi_hari +" Hari, "+durasi_jam+" Jam";
                }else{
                    durasi = durasi_jam +" Jam";
                }
                biaya_akhir = rupiah.format((biaya_jam*durasi_jam) + (biaya_hari*durasi_hari));
                String [] data = {no_tiket,no_pol,jenis,jam_masuk,tgl_masuk,durasi,biaya_akhir};
                return data;
            } else {
                return null;
            }
       } catch (Exception e) {
           e.printStackTrace();
       }
        return null;
   }
   
   private int toMins(String s) {
        String[] hourMin = s.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
   }
}
