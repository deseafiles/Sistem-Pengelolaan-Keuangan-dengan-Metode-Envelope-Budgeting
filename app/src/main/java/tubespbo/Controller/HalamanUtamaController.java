package tubespbo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HalamanUtamaController {

    @FXML
    private Button PemasukanButton;

    @FXML
    private ImageView PemasukanImage;

    @FXML
    private Button PengeluaranButton;

    @FXML
    private ImageView PengeluaranImage;

    @FXML
    private Button ProfileButton;

    @FXML
    private ImageView ProfileImage;

    @FXML
    private TableView<?> TransaksiTable;

    @FXML
    private TableColumn<?, ?> colJenis;

    @FXML
    private TableColumn<?, ?> colKategori;

    @FXML
    private TableColumn<?, ?> colNo;

    @FXML
    private TableColumn<?, ?> colPemasukkan;

    @FXML
    private TableColumn<?, ?> colPengeluaran;

    @FXML
    private TableColumn<?, ?> colTanggal;

    @FXML
    void handlePemasukanButtonAction(ActionEvent event) {
        loadPage("/tubespbo/FormPemasukan.fxml");
    }

    @FXML
    void handlePengeluaranButtonAction(ActionEvent event) {
        loadPage("/tubespbo/FormPengeluaran.fxml");
    }

    @FXML
    void handleProfileButtonAction(ActionEvent event) {
        loadPage("/tubespbo/Profile.fxml");
    }


    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
