package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.example.materialfx.database.DB_Handler;
import org.example.materialfx.model.User;

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

            SignUpButton.setOnAction(event -> {
                createUser();

                SignUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/login.fxml"));

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
    };

    private void createUser() {

        DB_Handler databaseHandler = new DB_Handler();

        String name = SignUpFirstName.getText();
        String lastname = SignUpLastName.getText();
        String username = SignUpUserName.getText();
        String password = SignUpPassword.getText();

        String gender;
        if(SignUpCheckBoxMale.isSelected()) {
            gender = "Männlich";
        } else gender = "Weiblich";

        User user = new User(name, lastname, username, password, gender);

        try {
            databaseHandler.signUpUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}


