package tubespbo.Dao;

import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenggunaDao {
    private Koneksi koneksi;

    public PenggunaDao(Koneksi koneksi) {
        this.koneksi = koneksi;
    }

    public Pengguna getPenggunaByNim(int nim) throws SQLException {
        String query = "SELECT nim, nama, jenis_kelamin FROM pengguna WHERE nim = ?";
        try (Connection conn = koneksi.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             stmt.setInt(1, nim);

             try (ResultSet rs = stmt.executeQuery()) {
                 if (rs.next()) {
                     return new Pengguna(rs.getInt("nim"), rs.getString("nama"), rs.getString("jenis_kelamin"));
                 } else {
                     return null;  // or throw an exception if the pengguna is not found
                 }
             }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
