package tubespbo.Models;

// Kelas Anggaran
public class Anggaran {
    protected static double totalAnggaranPokok;
    protected static double totalAnggaranSekunder;
    protected static double totalAnggaranTersier;
    protected Pengguna pengguna;

    public Anggaran(Pengguna pengguna, double totalAnggaranPokok, double totalAnggaranSekunder, double totalAnggaranTersier) {
        this.pengguna = pengguna;
        this.totalAnggaranPokok = totalAnggaranPokok;
        this.totalAnggaranSekunder = totalAnggaranSekunder;
        this.totalAnggaranTersier = totalAnggaranTersier;
    }

    // Metode getter
    public Pengguna getPengguna() {
        return pengguna;
    }

    public static double getTotalAnggaranPokok() {
        return totalAnggaranPokok;
    }

    public static double getTotalAnggaranSekunder() {
        return totalAnggaranSekunder;
    }

    public static double getTotalAnggaranTersier() {
        return totalAnggaranTersier;
    }

    // Metode setter
    public void setTotalAnggaranPokok(double totalAnggaranPokok) {
        this.totalAnggaranPokok = totalAnggaranPokok;
    }

    public void setTotalAnggaranSekunder(double totalAnggaranSekunder) {
        this.totalAnggaranSekunder = totalAnggaranSekunder;
    }

    public void setTotalAnggaranTersier(double totalAnggaranTersier) {
        this.totalAnggaranTersier = totalAnggaranTersier;
    }

    public double totalAnggaran() {
        return totalAnggaranPokok + totalAnggaranSekunder + totalAnggaranTersier;
    }
}
