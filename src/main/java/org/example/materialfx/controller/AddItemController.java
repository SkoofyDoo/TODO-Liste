package org.example.materialfx.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.example.materialfx.animations.Pulsator;
import org.example.materialfx.animations.Shaker;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemController {


    public AddItemController() {
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AddButton;

    @FXML
    private Label notTaskLabel;


    @FXML
    void initialize() {

        AddButton.setOnMouseClicked(event -> {
            Pulsator buttonPulsator = new Pulsator(AddButton);
            buttonPulsator.start();


            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), AddButton);
            System.out.println("Button clicked");

            AddButton.relocate(5,5);
            notTaskLabel.relocate(0,45);
            AddButton.setOpacity(0);
            notTaskLabel.setOpacity(0);

            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setCycleCount(1);
            fadeTransition.setAutoReverse(false);
            fadeTransition.play();




        });
    }
}

