package org.example.materialfx.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
    void initialize() {

        AddButton.setOnMouseClicked(event -> {
            Pulsator buttonPulsator = new Pulsator(AddButton);
            buttonPulsator.start();
            System.out.println("Button clicked");
        });
    }
}

