package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MFXButton LoginButton;

    @FXML
    private MFXPasswordField LoginPassword;

    @FXML
    private MFXButton LoginSignUpButton;

    @FXML
    private MFXTextField LoginUserName;

    @FXML
    void initialize() {
        LoginButton.setOnAction(event -> {
            System.out.println("Login Button Pressed");
        });

    }

}
