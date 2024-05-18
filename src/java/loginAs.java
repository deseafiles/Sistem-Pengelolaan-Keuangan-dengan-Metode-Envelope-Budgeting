package com.tubes.tugasbesarpbo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class loginAs {

    @FXML
    private Button ButtonPersonal;

    @FXML
    private Button ButtonGroup;

    public void initialize() {
        // Check if ButtonPersonal is null before setting its event handler
        if (ButtonPersonal != null) {
            ButtonPersonal.setOnAction(event -> {
                try {
                    changeScene("Personal.fxml", ButtonPersonal);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // Check if ButtonGroup is null before setting its event handler
        if (ButtonGroup != null) {
            ButtonGroup.setOnAction(event -> {
                try {
                    changeScene("Group.fxml", ButtonGroup);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void changeScene(String fxmlFile, Button button) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) button.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
