package tubespbo.Models;

import java.sql.Date;

// Kelas Pengeluaran
public class Pengeluaran extends Anggaran {
    private Date tanggalKeluar;
    private double uangPengeluaran;
    private String kategori;

    public Pengeluaran(Pengguna pengguna, double uangPengeluaran, String kategori, Date tanggalKeluar) {
        super(pengguna, Anggaran.getTotalAnggaranPokok(), Anggaran.getTotalAnggaranSekunder(), Anggaran.getTotalAnggaranTersier());
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
        if (uangPengeluaran > getTotalAnggaranPokok()) {
            throw new IllegalArgumentException("Jumlah pengeluaran pokok melebihi anggaran pokok");
        }
        setTotalAnggaranPokok(getTotalAnggaranPokok() - uangPengeluaran);
        return totalAnggaran();
    }


    public double addPengeluaranSekunder() {
        if (uangPengeluaran > getTotalAnggaranSekunder()) {
            throw new IllegalArgumentException("Jumlah pengeluaran sekunder melebihi anggaran sekunder");
        }
        setTotalAnggaranSekunder(getTotalAnggaranSekunder() - uangPengeluaran);
        return totalAnggaran();
    }

    public double addPengeluaranTersier() {
        if (uangPengeluaran > getTotalAnggaranTersier()) {
            throw new IllegalArgumentException("Jumlah pengeluaran tersier melebihi anggaran tersier");
        }
        setTotalAnggaranTersier(getTotalAnggaranTersier() - uangPengeluaran);
        return totalAnggaran();
    }

    @Override
    public String toString() {
        return getPengguna().getNama() + " telah menambah pengeluaran!";
    }
}
