package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

        String loginUserNameText = LoginUserName.getText().trim();
        String loginPasswordText = LoginPassword.getText().trim();

        LoginSignUpButton.setOnAction(event -> {
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

        LoginButton.setOnAction(event -> {
            if(!loginUserNameText.isEmpty() || !loginPasswordText.isEmpty()) {
                loginUser(loginUserNameText,loginPasswordText);
            } else {
                System.out.println("Error login");
            }
        });

    }
    private void loginUser(String userName, String password) {



    }

}
