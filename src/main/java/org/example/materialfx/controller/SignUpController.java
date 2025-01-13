package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import org.example.materialfx.database.DB_Handler;

import java.net.URL;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class SignUpController {

    public String gender;

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

            DB_Handler databaseHandler = new DB_Handler();


            SignUpButton.setOnAction(event -> {
                try {
                    databaseHandler.signUpUser(SignUpFirstName.getText(), SignUpLastName.getText(),
                            SignUpUserName.getText(),
                            SignUpPassword.getText(),
                            "Männlich");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        };

    }

