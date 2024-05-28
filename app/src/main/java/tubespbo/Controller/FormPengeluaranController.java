package tubespbo.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import tubespbo.Dao.PengeluaranDao;
import tubespbo.Models.Pengeluaran;
import tubespbo.Models.Pengguna;
import tubespbo.Util.Koneksi;

import java.sql.Date;
import java.time.LocalDate;

public class FormPengeluaranController {

    @FXML
    private TextField nimField;

    @FXML
    private TextField uangPengeluaranField;

    @FXML
    private TextField kategoriField;

    @FXML
    private DatePicker tanggalKeluarPicker;

    @FXML
    private ComboBox<String> kategoriPrioritasComboBox;

    private PengeluaranDao pengeluaranDao;

    public FormPengeluaranController() {
        Koneksi koneksi = new Koneksi();
        this.pengeluaranDao = new PengeluaranDao(koneksi);
    }
    //ketika menekan tombol
    @FXML
    private void handleSave() {
        try {
            int nim = Integer.parseInt(nimField.getText());
            double uangPengeluaran = Double.parseDouble(uangPengeluaranField.getText());
            String kategori = kategoriField.getText();
            LocalDate tanggalKeluar = tanggalKeluarPicker.getValue();
            String kategoriPrioritas = kategoriPrioritasComboBox.getValue();

            Pengguna pengguna = pengeluaranDao.getPenggunaDao().getPenggunaByNim(nim);
            //mencari apakah pengguna dengan nim terkait terdaftar di database pengguna, jika tidak baris ini dijalankan
            if (pengguna == null) {
                throw new Exception("Pengguna dengan NIM " + nim + " tidak ditemukan.");
            }

            Pengeluaran pengeluaran = new Pengeluaran(pengguna, uangPengeluaran, kategori, Date.valueOf(tanggalKeluar));
            //switch case jika pengguna memilih jenis prioritas maka akan mengurangi uang di jenis pengeluaran terkait
            switch (kategoriPrioritas) {
                case "Pokok":
                    pengeluaran.addPengeluaranPokok();
                    break;
                case "Sekunder":
                    pengeluaran.addPengeluaranSekunder();
                    break;
                case "Tersier":
                    pengeluaran.addPengeluaranTersier();
                    break;
                default:
                    throw new IllegalArgumentException("Kategori prioritas tidak valid");
            }
            //jika semua berhasil dijalankan, maka akan menambah data di database postgresql dengan table pengeluaran
            pengeluaranDao.tambahPengeluaranAnggaran(pengeluaran);
            System.out.println(pengeluaran);
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
