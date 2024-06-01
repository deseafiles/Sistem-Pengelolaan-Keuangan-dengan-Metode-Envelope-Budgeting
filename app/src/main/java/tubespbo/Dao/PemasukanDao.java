package tubespbo.Dao;

import tubespbo.Models.Pemasukan;
import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PemasukanDao {
    private Koneksi koneksi;
    private PenggunaDao penggunaDao;

    public PemasukanDao(Koneksi koneksi) {
        this.koneksi = koneksi;
        this.penggunaDao = new PenggunaDao(koneksi);
    }

    public PenggunaDao getPenggunaDao() {
        return penggunaDao;
    }

    public List<Pemasukan> getAllPemasukan() throws SQLException {
        List<Pemasukan> pemasukanList = new ArrayList<>();
        String query = "SELECT nim, total_anggaran_pokok, total_anggaran_sekunder, " +
                "total_anggaran_tersier, uang_pemasukan, sumber, tanggal_masuk " +
                "FROM public.pemasukan";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int penggunaNim = rs.getInt("nim");
                Pengguna pengguna = penggunaDao.getPenggunaByNim(penggunaNim);

                if (pengguna != null) {
                    Pemasukan pemasukan = new Pemasukan(
                            pengguna,
                            rs.getDouble("total_anggaran_pokok"),
                            rs.getDouble("total_anggaran_sekunder"),
                            rs.getDouble("total_anggaran_tersier"),
                            rs.getDouble("uang_pemasukan"),
                            rs.getString("sumber"),
                            rs.getDate("tanggal_masuk")
                    );
                    pemasukanList.add(pemasukan);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return pemasukanList;
    }

    public void tambahPemasukanAnggaran(Pemasukan pemasukan) throws SQLException {
        String query = "INSERT INTO pemasukan (nim, total_anggaran_pokok, total_anggaran_sekunder, total_anggaran_tersier, uang_pemasukan, sumber, tanggal_masuk) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, pemasukan.getPengguna().getNim());
            stmt.setDouble(2, pemasukan.getTotalAnggaranPokok());
            stmt.setDouble(3, pemasukan.getTotalAnggaranSekunder());
            stmt.setDouble(4, pemasukan.getTotalAnggaranTersier());
            stmt.setDouble(5, pemasukan.getUangPemasukan());
            stmt.setString(6, pemasukan.getSumber());
            stmt.setDate(7, new java.sql.Date(pemasukan.getTanggalMasuk().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
