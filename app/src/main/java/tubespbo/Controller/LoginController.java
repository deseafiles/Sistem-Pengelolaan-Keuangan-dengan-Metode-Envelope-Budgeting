package tubespbo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tubespbo.Dao.PenggunaDao;
import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Button LoginButton;
    @FXML
    private TextField NamaField;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField NIMField;

    private PenggunaDao penggunaDao;

    public LoginController() {
        Koneksi koneksi = new Koneksi();
        penggunaDao = new PenggunaDao(koneksi);
    }

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void changeScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tubespbo/HalamanUtama.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) LoginButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void checkLogin() throws IOException {
        String nimStr = NIMField.getText().toString();
        String nama = NamaField.getText().toString();

        if (nimStr.matches("^[0-9]+$") && nama.matches("^[a-zA-Z]+$")) {
            int nim = Integer.parseInt(nimStr);
            try {
                Pengguna pengguna = penggunaDao.getPenggunaByNim(nim);

                if (pengguna != null && pengguna.getNama().equals(nama)) {
                    wrongLogin.setText("Berhasil!");
                    changeScene();
                } else {
                    wrongLogin.setText("Nama dan NIM Salah");
                }
            } catch (SQLException e) {
                wrongLogin.setText("Terjadi kesalahan pada database");
                e.printStackTrace();
            }
        } else if (nama.isEmpty() || nimStr.isEmpty()) {
            wrongLogin.setText("Tidak Boleh Kosong!");
        } else {
            wrongLogin.setText("Nama dan NIM Salah");
        }
    }
}