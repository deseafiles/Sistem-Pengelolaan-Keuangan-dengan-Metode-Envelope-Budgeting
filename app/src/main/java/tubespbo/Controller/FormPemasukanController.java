package tubespbo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import tubespbo.Dao.PemasukanDao;
import tubespbo.Models.Pemasukan;
import tubespbo.Models.Pengguna;
import tubespbo.Models.Prioritas;
import tubespbo.Util.Koneksi;

import java.sql.Date;
import java.time.LocalDate;

public class FormPemasukanController {

    @FXML
    private TextField nimField;

    @FXML
    private TextField uangPemasukanField;

    @FXML
    private TextField sumberField;

    @FXML
    private DatePicker tanggalMasukPicker;

    private PemasukanDao pemasukanDao;

    public FormPemasukanController() {
        Koneksi koneksi = new Koneksi();
        this.pemasukanDao = new PemasukanDao(koneksi);
    }

    @FXML
    private void handleSave() {
        try {
            int nim = Integer.parseInt(nimField.getText());
            double uangPemasukan = Double.parseDouble(uangPemasukanField.getText());
            String sumber = sumberField.getText();
            LocalDate tanggalMasuk = tanggalMasukPicker.getValue();

            Pengguna pengguna = pemasukanDao.getPenggunaDao().getPenggunaByNim(nim);

            if (pengguna == null) {
                throw new Exception("Pengguna dengan NIM " + nim + " tidak ditemukan.");
            }

            // Initialize Pemasukan object with appropriate values
            Pemasukan pemasukan = new Pemasukan(
                    pengguna,
                    pengguna.getTotalAnggaranPokok(),
                    pengguna.getTotalAnggaranSekunder(),
                    pengguna.getTotalAnggaranTersier(),
                    uangPemasukan,
                    sumber,
                    Date.valueOf(tanggalMasuk)
            );

            Prioritas prioritas = new Prioritas(pemasukan);
            prioritas.pembagianUangMasuk();
            pemasukanDao.tambahPemasukanAnggaran(prioritas.getPemasukan());
            System.out.println(pemasukan);
        } catch (Exception e) {
            e.printStackTrace();
            showErrorMessage("Data tidak berhasil disimpan.", e);
        }
    }

    private void showErrorMessage(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message + "\n\n" + e.getMessage());
        alert.showAndWait();
    }
}
