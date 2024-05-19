package sistemkeuangan;

import java.util.Date;

public class Pemasukan extends Anggaran {
    private double totalPemasukan;
    private String sumber;

    public Pemasukan(double totalPemasukan, String Sumber, double totalAnggaran,Date tanggal String sumber) {
        super(totalAnggaran, tanggal, deskripsi);
        this.totalPemasukan = totalPemasukan;
        this.sumber = sumber;
    }

    // getter methods
    public double getTotalPemasukan() {
        return this.totalPemasukan;
    }

    public String getSumber() {
        return this.sumber;
    }

    // setter methods
    public void setTotalPemasukan(double totalPemasukan) {
        this.totalPemasukan = totalPemasukan;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    // additional methods
    public double addPemasukan() {
        this.totalAnggaran += this.totalPemasukan;
        return this.totalAnggaran;
    }
}