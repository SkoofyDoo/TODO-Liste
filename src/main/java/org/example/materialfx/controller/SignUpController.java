package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MFXButton SignUpButton;

    @FXML
    private MFXCheckbox SignUpCheckBoxFemale;

    @FXML
    private MFXCheckbox SignUpCheckBoxMale;

    @FXML
    private MFXTextField SignUpFirstName;

    @FXML
    private MFXTextField SignUpLastName;

    @FXML
    private MFXPasswordField SignUpPassword;

    @FXML
    private MFXTextField SignUpUserName;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {
            System.out.println("SignUp Button Pressed");
        });

    }
}
