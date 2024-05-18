package com.tubes.tugasbesarpbo;
import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
public class Login {

    public Login() {

    }

    @FXML
    private Button LoginButton;
    @FXML
    private TextField NamaField;
    @FXML
    private TextField UsiaField;
    @FXML
    private Label wrongLogin ;
    @FXML
    private TextField NIMField ;


    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    private void changeScene(String fxmlFile) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) LoginButton.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    private void checkLogin() throws IOException {
        if (NamaField.getText().toString().matches("^[a-zA-Z]+$") && UsiaField.getText().toString().matches("^[0-9]+$") && NIMField.getText().toString().matches("^[0-9]+$") && Integer.parseInt(UsiaField.getText()) >= 18) {
            wrongLogin.setText("success!");

           changeScene("LoginAs.fxml");
        } else if (NamaField.getText().toString().isEmpty() && UsiaField.getText().isEmpty()) {
            wrongLogin.setText("Jangan dikosongin woy");
        }

        else {
            wrongLogin.setText("Nama dan Usia Salah");
        }

    }
}
