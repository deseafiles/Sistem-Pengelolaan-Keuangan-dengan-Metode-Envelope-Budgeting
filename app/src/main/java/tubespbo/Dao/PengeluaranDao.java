package tubespbo.Dao;

import tubespbo.Models.Pengeluaran;
import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengeluaranDao {
    private Koneksi koneksi;
    private PenggunaDao penggunaDao;

    public PengeluaranDao(Koneksi koneksi) {
        this.koneksi = koneksi;
        this.penggunaDao = new PenggunaDao(koneksi); // Inisialisasi PenggunaDao
    }

    public List<Pengeluaran> getAllPengeluaran() throws SQLException {
        List<Pengeluaran> pemasukanList = new ArrayList<>();
        String query = "SELECT nim, total_anggaran_pokok, total_anggaran_sekunder, total_anggaran_tersier, uang_pengeluaran, kategori, tanggal_keluar FROM public.pengeluaran";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int penggunaNim = rs.getInt("nim");
                Pengguna pengguna = penggunaDao.getPenggunaByNim(penggunaNim);

                if (pengguna != null) {
                    Pengeluaran pengeluaran = new Pengeluaran(
                            pengguna,
                            rs.getDouble("total_anggaran_pokok"),
                            rs.getDouble("total_anggaran_sekunder"),
                            rs.getDouble("total_anggaran_tersier"),
                            rs.getDouble("uang_pengeluaran"),
                            rs.getString("kategori"),
                            rs.getDate("tanggal_masuk")
                    );
                    pemasukanList.add(pengeluaran);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return pemasukanList;
    }

    public void tambahPengeluaranAnggaran(Pengeluaran pengeluaran) throws SQLException {
        String query = "INSERT INTO public.pengeluaran( nim, total_anggaran_pokok, total_anggaran_sekunder, total_anggaran_tersier, uang_pengeluaran, kategori, tanggal_keluar) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set parameter-parameter yang sesuai dengan nilai dari objek Pemasukan
            stmt.setInt(1, pengeluaran.getPengguna().getNim());
            stmt.setDouble(2, pengeluaran.getTotalAnggaranPokok());
            stmt.setDouble(3, pengeluaran.getTotalAnggaranSekunder());
            stmt.setDouble(4, pengeluaran.getTotalAnggaranTersier());
            stmt.setDouble(5, pengeluaran.getUangPengeluaran());
            stmt.setString(6, pengeluaran.getKategori());
            stmt.setDate(7, new java.sql.Date(pengeluaran.getTanggalKeluar().getTime()));
            // Jalankan pernyataan SQL untuk menambahkan data ke database
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
