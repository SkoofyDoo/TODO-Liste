package org.example.materialfx.controller;


import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import org.example.materialfx.animations.Pulsator;

import org.example.materialfx.database.DB_Handler;
import org.example.materialfx.model.Task;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;


public class AddItemFormController {

    private static int userID;

    private DB_Handler databaseHandler;

    private MFXDatePicker datePicker;

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

        // DB_Handler databaseHandler = new DB_Handler();

        AddFormBackButton.setOnMouseClicked(event -> {

            Pulsator buttonPulsator = new Pulsator(AddFormBackButton);
            buttonPulsator.start();
            System.out.println("Back Button clicked");

            if(datePicker != null) {
                System.out.println("Datum: " + datePicker.getValue());
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

        databaseHandler = new DB_Handler();


        // HINZUFÜGEN - BUTTON
        AddFormAddButton.setOnMouseClicked(event -> {

            Task task = getTask();

            try {

                databaseHandler.addTask(task);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            AddFormAddButton.getScene().getWindow().hide();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/materialfx/addItem.fxml"));

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        });

    }

    private Task getTask() {
        Task task = new Task();

        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(calendar.getTimeInMillis());

        String taskText = AddFormTask.getText();
        String description = AddFormDescription.getText();


        if (!taskText.isEmpty()||!description.isEmpty()) {
            System.out.println("ID ist: " + AddItemController.userID);
            task.setUserID(AddItemController.userID);
            task.setTask(taskText);
            task.setDateCreated(timestamp);
            task.setTaskDescription(description);
        }
        return task;
    }

}

