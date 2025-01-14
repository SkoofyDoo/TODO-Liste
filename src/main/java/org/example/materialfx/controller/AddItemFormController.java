package org.example.materialfx.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.materialfx.animations.Pulsator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddItemFormController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MFXButton AddFormAddButton;

    @FXML
    private ImageView AddFormBackButton;

    @FXML
    private MFXDatePicker AddFormDate;

    @FXML
    private TextField AddFormDescription;

    @FXML
    private TextField AddFormTask;




    @FXML
    void initialize() {




        AddFormBackButton.setOnMouseClicked(event -> {

            Pulsator buttonPulsator = new Pulsator(AddFormBackButton);
            buttonPulsator.start();
            System.out.println("Back Button clicked");

            ArrayList<String> taskInfo = new ArrayList<>();

            MFXDatePicker datePicker = new MFXDatePicker();
            LocalDate selectedDate = datePicker.getValue();

            if(selectedDate != null) {
                System.out.println("Datum: " + selectedDate);
            } else {
                System.out.println("No Datum");
            }

            AddFormBackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));

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

        AddFormAddButton.setOnMouseClicked(event -> {
            AddFormAddButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));

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




    }
}
