package tubespbo.Util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {

    private static final String URL = "jdbc:postgresql://localhost:5432/test";  // Ganti dengan URL database Anda
    private static final String USER = "asus";  // Ganti dengan username database Anda
    private static final String PASSWORD = "root";  // Ganti dengan password database Anda

    // Metode untuk mendapatkan koneksi ke database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Statement createStatement() throws SQLException {
        Connection connection = getConnection();
        return connection.createStatement();
    }

    // Metode untuk menutup koneksi
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metode untuk menutup statement
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

