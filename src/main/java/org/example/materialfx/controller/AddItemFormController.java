package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.materialfx.animations.Pulsator;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MFXButton AddFormAddButton;

    @FXML
    private ImageView AddFormBackButton;

    @FXML
    private MFXDatePicker AddFormDate;

    @FXML
    private TextField AddFormDescription;

    @FXML
    private TextField AddFormTask;

    @FXML
    void initialize() {

        AddFormBackButton.setOnMouseClicked(event -> {

            Pulsator buttonPulsator = new Pulsator(AddFormBackButton);
            buttonPulsator.start();
            System.out.println("Back Button clicked");
            AddFormBackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        });

        AddFormAddButton.setOnMouseClicked(event -> {
            AddFormAddButton.getScene().getWindow().hide();
        });


    }
}
