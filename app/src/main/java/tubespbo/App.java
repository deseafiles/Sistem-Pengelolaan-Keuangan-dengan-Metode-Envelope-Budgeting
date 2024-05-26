package tubespbo;

import tubespbo.Models.*;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Membuat pengguna

        while(True) {


        }

        Pengguna pengguna = new Pengguna("John Doe");

        // Membuat pemasukan
        LocalDate tanggalMasuk = LocalDate.now();
        Pemasukan pemasukan = new Pemasukan(pengguna, 5000, 3000, 2000, 10000, "Gaji", tanggalMasuk);

        // Membuat prioritas
        Prioritas prioritas = new Prioritas(pemasukan);

        // Menambahkan pengeluaran
        LocalDate tanggalKeluar = LocalDate.now();
        Pengeluaran pengeluaran = new Pengeluaran(pengguna, 5000, 3000, 2000, "pokok", tanggalKeluar, 2000);
        prioritas.addPengeluaranPrioritas(pengeluaran);

        // Mengecek total anggaran setelah pengeluaran
        double totalAnggaran = pemasukan.totalAnggaran();

        System.out.println(pemasukan);
        System.out.println(pengeluaran);
        System.out.println("Total anggaran setelah pengeluaran: " + totalAnggaran);
    }
}
