package sistemparkir.model;


/**
 *
 * @author Ammar Amri
 */
public class PendapatanModel {
    private String no_tiket,no_polisi,tgl_keluar,biaya;

    public PendapatanModel(String no_tiket, String no_polisi, String tgl_keluar, String biaya) {
        this.no_tiket = no_tiket;
        this.no_polisi = no_polisi;
        this.tgl_keluar = tgl_keluar;
        this.biaya = biaya;
    }

    public String getNo_tiket() {
        return no_tiket;
    }

    public String getNo_polisi() {
        return no_polisi;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public String getBiaya() {
        return biaya;
    }
    
    
}
