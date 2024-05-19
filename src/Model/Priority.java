package sistemkeuangan;

public class Priority {
    private double persenPokok;
    private double persenSekunder;
    private double persenTersier;

    public Priority(double persenPokok, double persenSekunder, double persenTersier) {
        this.persenPokok = persenPokok;
        this.persenSekunder = persenSekunder;
        this.persenTersier = persenTersier;
    }

    // getter methods
    public double getPersenPokok() {
        return this.persenPokok;
    }

    public double getPersenSekunder() {
        return this.persenSekunder;
    }

    public double getPersenTersier() {
        return this.persenTersier;
    }

    // setter methods
    public void setPersenPokok(double persenPokok) {
        this.persenPokok = persenPokok;
    }

    public void setPersenSekunder(double persenSekunder) {
        this.persenSekunder = persenSekunder;
    }

    public void setPersenTersier(double persenTersier) {
        this.persenTersier = persenTersier;
    }

    // method to calculate total pemasukan based on priorities
    public double hitungTotalPemasukan(double totalPemasukan) {
        double totalPokok = (this.persenPokok / 100) * totalPemasukan;
        double totalSekunder = (this.persenSekunder / 100) * totalPemasukan;
        double totalTersier = (this.persenTersier / 100) * totalPemasukan;

        return totalPokok + totalSekunder + totalTersier;
    }
}
