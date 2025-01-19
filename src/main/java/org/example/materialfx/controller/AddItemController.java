package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.materialfx.animations.Pulsator;
import org.example.materialfx.database.DB_Handler;


import java.io.IOException;


public class AddItemController {

    public AddItemController() {
    }

    public static int userID;

    @FXML
    private ImageView AddButton;

    @FXML
    private Label notTaskLabel;

    @FXML
    private MFXButton logOutButton;

    
    @FXML
    void initialize() {

        DB_Handler databaseHandler = new DB_Handler();

        AddButton.setOnMouseClicked(event -> {

            Pulsator buttonPulsator = new Pulsator(AddButton);
            buttonPulsator.start();

            AddButton.getScene().getWindow().hide();

            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(2000), AddButton);
            System.out.println("Button clicked");



            AddButton.relocate(5,5);
            notTaskLabel.relocate(0,45);
            AddButton.setOpacity(0);
            notTaskLabel.setOpacity(0);

            fadeTransition2.setFromValue(1);
            fadeTransition2.setToValue(0);
            fadeTransition2.setCycleCount(2);
            fadeTransition2.setAutoReverse(false);
            fadeTransition2.play();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/org/example/materialfx/addItemForm.fxml"));


            try {
                AddItemController.userID = getUserID();
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();


        });
    }

    private int getUserID() {
        return userID;
    }

    public void setUserID (int userID) {
        AddItemController.userID = userID;
        System.out.println("User ID: " + userID);
    }




}



