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

    public PenggunaDao getPenggunaDao() {
        return penggunaDao;
    }

    public List<Pengeluaran> getAllPengeluaran() throws SQLException {
        List<Pengeluaran> pengeluaranList = new ArrayList<>();
        String query = "SELECT nim, uang_pengeluaran, kategori, tanggal_keluar FROM public.pengeluaran";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int penggunaNim = rs.getInt("nim");
                Pengguna pengguna = penggunaDao.getPenggunaByNim(penggunaNim);

                if (pengguna != null) {
                    Pengeluaran pengeluaran = new Pengeluaran(
                            pengguna,
                            rs.getDouble("uang_pengeluaran"),
                            rs.getString("kategori"),
                            rs.getDate("tanggal_keluar")
                    );
                    pengeluaranList.add(pengeluaran);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return pengeluaranList;
    }

    public void tambahPengeluaranAnggaran(Pengeluaran pengeluaran) throws SQLException {
        String query = "INSERT INTO public.pengeluaran(nim, uang_pengeluaran, kategori, tanggal_keluar) VALUES (?, ?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set parameter-parameter yang sesuai dengan nilai dari objek Pengeluaran
            stmt.setInt(1, pengeluaran.getPengguna().getNim());
            stmt.setDouble(2, pengeluaran.getUangPengeluaran());
            stmt.setString(3, pengeluaran.getKategori());
            stmt.setDate(4, new java.sql.Date(pengeluaran.getTanggalKeluar().getTime()));
            // Jalankan pernyataan SQL untuk menambahkan data ke database
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
