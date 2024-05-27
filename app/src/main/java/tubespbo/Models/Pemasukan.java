package tubespbo.Models;

import java.sql.Date;

// Kelas Pemasukan
public class Pemasukan extends Anggaran {
    private double uangPemasukan;
    private String sumber;
    private Date tanggalMasuk;


    public Pemasukan( Pengguna pengguna, double totalAnggaranPokok, double totalAnggaranSekunder, double totalAnggaranTersier, double uangPemasukan, String sumber, Date tanggalMasuk) {
        super(pengguna, totalAnggaranPokok, totalAnggaranSekunder, totalAnggaranTersier);
        this.tanggalMasuk = tanggalMasuk;
        this.uangPemasukan = uangPemasukan;
        this.sumber = sumber;
    }

    // Metode getter


    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public double getUangPemasukan() {
        return this.uangPemasukan;
    }

    public String getSumber() {
        return this.sumber;
    }

    // Metode setter
    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public void setUangPemasukan(double uangPemasukan) {
        if (uangPemasukan < 0) {
            throw new IllegalArgumentException("Saldo tidak boleh negatif");
        }
        this.uangPemasukan = uangPemasukan;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    @Override
    public String toString() {
        return super.getPengguna().getNama() + " telah menambah pemasukan!";
    }
}
