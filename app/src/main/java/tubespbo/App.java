package tubespbo;

import tubespbo.Util.Koneksi;

import java.sql.Connection;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Koneksi koneksi = new Koneksi();
            connection = koneksi.getConnection();

            if (Koneksi.isConnected(connection)) {
                System.out.println("Koneksi ke database berhasil.");
            } else {
                System.out.println("Koneksi ke database gagal.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Koneksi.close(connection);
        }

    }
}

