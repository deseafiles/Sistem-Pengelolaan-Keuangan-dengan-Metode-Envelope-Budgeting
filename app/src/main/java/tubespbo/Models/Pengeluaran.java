package tubespbo.Models;

import java.sql.Date;
import java.time.LocalDate;

// Kelas Pengeluaran
public class Pengeluaran extends Anggaran {
    private Date tanggalKeluar;
    private double uangPengeluaran;
    private String kategori;


    public Pengeluaran(Pengguna pengguna, double totalAnggaranPokok, double totalAnggaranSekunder, double totalAnggaranTersier, double uangPengeluaran, String kategori, Date tanggalKeluar) {
        super(pengguna, totalAnggaranPokok, totalAnggaranSekunder, totalAnggaranTersier);
        this.uangPengeluaran = uangPengeluaran;
        this.tanggalKeluar = tanggalKeluar;
        this.kategori = kategori;
    }

    // Metode getter
    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public double getUangPengeluaran() {
        return uangPengeluaran;
    }

    public String getKategori() {
        return kategori;
    }

    // Metode setter
    public void setTanggalKeluar(Date tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public void setUangPengeluaran(double uangPengeluaran) {
        this.uangPengeluaran = uangPengeluaran;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    // Metode untuk mengurangi anggaran sesuai kategori
    public double addPengeluaranPokok() {
        if (uangPengeluaran > totalAnggaranPokok) {
            throw new IllegalArgumentException("Jumlah pengeluaran pokok melebihi anggaran pokok");
        }
        this.totalAnggaranPokok -= this.uangPengeluaran;
        return this.totalAnggaran();
    }

    public double addPengeluaranSekunder() {
        if (uangPengeluaran > totalAnggaranSekunder) {
            throw new IllegalArgumentException("Jumlah pengeluaran sekunder melebihi anggaran sekunder");
        }
        this.totalAnggaranSekunder -= this.uangPengeluaran;
        return this.totalAnggaran();
    }

    public double addPengeluaranTersier() {
        if (uangPengeluaran > totalAnggaranTersier) {
            throw new IllegalArgumentException("Jumlah pengeluaran tersier melebihi anggaran tersier");
        }
        this.totalAnggaranTersier -= this.uangPengeluaran;
        return this.totalAnggaran();
    }

    @Override
    public String toString() {
        return super.getPengguna().getNama() + " telah menambah pengeluaran!";
    }
}