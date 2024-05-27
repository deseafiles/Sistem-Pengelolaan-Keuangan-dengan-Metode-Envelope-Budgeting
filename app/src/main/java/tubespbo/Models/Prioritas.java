package tubespbo.Models;

// Kelas Prioritas
public class Prioritas {
    private Pemasukan pemasukan;
    private final double persenPokok = 50.0;
    private final double persenSekunder = 35.0;
    private final double persenTersier = 15.0;

    public Prioritas(Pemasukan pemasukan) {
        this.pemasukan = pemasukan;
    }

    // Metode getter
    public Pemasukan getPemasukan() {
        return pemasukan;
    }

    public double getPersenPokok() {
        return persenPokok;
    }

    public double getPersenSekunder() {
        return persenSekunder;
    }

    public double getPersenTersier() {
        return persenTersier;
    }

    // Metode untuk menghitung total pemasukan berdasarkan prioritasnya
    // Jika ada uang masuk, maka metode ini akan digunakan
    public double pembagianUangMasuk() {
        double totalPemasukan = pemasukan.getUangPemasukan(); // Mendapatkan nilai pemasukan dari objek Pemasukan
        double totalPokok = (persenPokok / 100.0) * totalPemasukan;
        double totalSekunder = (persenSekunder / 100.0) * totalPemasukan;
        double totalTersier = (persenTersier / 100.0) * totalPemasukan;

        return totalPokok + totalSekunder + totalTersier;
    }

    // Metode untuk menambah pengeluaran
    public void addPengeluaranPrioritas(Pengeluaran pengeluaran) {
        String jenis = pengeluaran.getKategori().toLowerCase();
        double jumlah = pengeluaran.getUangPengeluaran();

        switch (jenis) {
            case "pokok":
                if (jumlah > (persenPokok / 100) * pemasukan.getUangPemasukan()) {
                    throw new IllegalArgumentException("Jumlah pengeluaran pokok melebihi batas");
                }
                pengeluaran.addPengeluaranPokok();
                break;
            case "sekunder":
                if (jumlah > (persenSekunder / 100) * pemasukan.getUangPemasukan()) {
                    throw new IllegalArgumentException("Jumlah pengeluaran sekunder melebihi batas");
                }
                pengeluaran.addPengeluaranSekunder();
                break;
            case "tersier":
                if (jumlah > (persenTersier / 100) * pemasukan.getUangPemasukan()) {
                    throw new IllegalArgumentException("Jumlah pengeluaran tersier melebihi batas");
                }
                pengeluaran.addPengeluaranTersier();
                break;
            default:
                throw new IllegalArgumentException("Jenis pengeluaran tidak dikenal");
        }
    }
}