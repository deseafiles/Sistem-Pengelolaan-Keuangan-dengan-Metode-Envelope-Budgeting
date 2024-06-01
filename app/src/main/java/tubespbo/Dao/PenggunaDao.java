package tubespbo.Dao;

import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenggunaDao {
    private Koneksi koneksi;
    private Pengguna pengguna;

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

        public void tambahPengguna(Pengguna pengguna) throws SQLException {
            String query = "INSERT INTO public.pengguna(nim, nama, jenis_kelamin) VALUES (?, ?, ?)";

            try (Connection conn = Koneksi.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                // Set parameter-parameter yang sesuai dengan nilai dari objek Pengeluaran
                stmt.setString(1, pengguna.getNama());
                stmt.setInt(2, pengguna.getNim());
                stmt.setString(3, pengguna.getJenisKelamin());
                // Jalankan pernyataan SQL untuk menambahkan data ke database
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }
}
