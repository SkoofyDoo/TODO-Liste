package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.materialfx.animations.Pulsator;
import org.example.materialfx.animations.Shaker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.ToDoubleBiFunction;

public class AddItemController {


    public AddItemController() {
    }

    @FXML
    private ImageView AddButton;

    @FXML
    private Label notTaskLabel;

    @FXML
    private MFXButton logOutButton;

    
    @FXML
    void initialize() {



//        logOutButton.setOnMouseClicked(event -> {
//           logOutButton.getScene().getWindow().hide();
//           FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/login.fxml"));
//           try {
//               loader.load();
//           } catch (IOException e) {
//               throw new RuntimeException(e);
//           }
//           Parent root = loader.getRoot();
//           Stage stage = new Stage();
//           stage.setScene(new Scene(root));
//           stage.show();
//        });


        AddButton.setOnMouseClicked(event -> {
            Pulsator buttonPulsator = new Pulsator(AddButton);
            buttonPulsator.start();

            AddButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItemForm.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();


            FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(2000), AddButton);
            System.out.println("Button clicked");



            AddButton.relocate(5,5);
            notTaskLabel.relocate(0,45);
            AddButton.setOpacity(0);
            notTaskLabel.setOpacity(0);

            fadeTransition2.setFromValue(1);
            fadeTransition2.setToValue(0);
            fadeTransition2.setCycleCount(1);
            fadeTransition2.setAutoReverse(false);
            fadeTransition2.play();




        });
    }
}

