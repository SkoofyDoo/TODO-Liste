package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
            AddFormAddButton.getScene().getWindow().hide();
        });


    }
}
