package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.materialfx.database.DB_Handler;
import org.example.materialfx.model.User;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class LoginController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private MFXButton LoginButton;

    @FXML
    private MFXPasswordField LoginPassword;

    @FXML
    private MFXButton LoginSignUpButton;

    @FXML
    private MFXTextField LoginUserName;


    private DB_Handler databaseHandler;

    @FXML
    void initialize() {

        String loginUserNameText = LoginUserName.getText().trim();
        String loginPasswordText = LoginPassword.getText().trim();

        User user = new User();
        user.setUsername(loginUserNameText);
        user.setPassword(loginPasswordText);

        LoginButton.setOnAction(event -> {
            databaseHandler = new DB_Handler();

            try {
                ResultSet result = databaseHandler.getUser(user);

                if (result.next()) {
                    System.out.println("Login erfolgreich");
                    LoginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));
                } else {
                    System.out.println("Login fehlgeschlagen");
                }

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();

            }
            ;

            LoginSignUpButton.setOnAction(event2 -> {
                // Nach dem Tätigen der Sign Up button, wird das Login fenster ausgeblendet
                LoginSignUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/signup.fxml"));

                try {
                    loader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new javafx.scene.Scene(root));
                stage.showAndWait();
            });

        });
    }
}


