package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.example.materialfx.animations.Shaker;
import org.example.materialfx.database.DB_Handler;
import org.example.materialfx.model.User;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class LoginController {

    private int userID;
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

        databaseHandler = new DB_Handler();



        LoginButton.setOnAction(event -> {


            String loginUserNameText = LoginUserName.getText().trim();
            String loginPasswordText = LoginPassword.getText().trim();


            User user = new User();
            user.setUsername(loginUserNameText);
            user.setPassword(loginPasswordText);


            try {
                ResultSet result = databaseHandler.getUser(user);

                int counter = 0;

                // Null-Prüfung implementiert
                while (result.next()) {
                    counter++;

                    System.out.println("Willkommen " + result.getString("firstname") + " " + result.getString("userid"));
                    userID = result.getInt("userid");


                }   if (counter == 1){

                    LoginButton.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));
                    loader.load();
                    Parent root = loader.getRoot();

                    Stage stage = new Stage();
                    stage.setScene(new javafx.scene.Scene(root));

                    AddItemController controller = loader.getController();
                    controller.setUserID(userID);

                    stage.showAndWait();

                }   else {
                        // shaker für optische Wahrnehmung
                        Shaker userFieldShaker = new Shaker(LoginUserName);
                        userFieldShaker.shake();

                        Shaker passFieldShaker = new Shaker(LoginPassword);
                        passFieldShaker.shake();

                        System.out.println("Login fehlgeschlagen: Benutzer nicht gefunden oder falsches Passwort.");
                    }
            } catch (SQLException | ClassNotFoundException | IOException e) {
                System.err.println("Fehler bei der Datenbankabfrage:");
                e.printStackTrace();
            }


        });

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

    }

}


