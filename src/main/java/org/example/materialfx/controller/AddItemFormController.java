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
import org.example.materialfx.database.Const;
import org.example.materialfx.database.DB_Handler;
import org.example.materialfx.model.Task;
import org.example.materialfx.model.User;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
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
            createTask();
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

    public void createTask() {

            DB_Handler databaseHandler = new DB_Handler();
            Task task1 = new Task();

            // Werte aus den Eingabefeldern abrufen
            String task = AddFormTask.getText();
            String description = AddFormDescription.getText();
            LocalDate datecreated = AddFormDate.getValue();

            // Validierung der Benutzereingaben
            if (task == null || task.trim().isEmpty()) {
                System.out.println("Das Feld 'Task' darf nicht leer sein.");
                return;
            }
            if (description == null || description.trim().isEmpty()) {
                System.out.println("Das Feld 'Beschreibung' darf nicht leer sein.");
                return;
            }
            if (datecreated == null) {
                System.out.println("Bitte wählen Sie ein Datum aus.");
                return;
            }

            java.sql.Date sqlDate = java.sql.Date.valueOf(datecreated);

            int userId = databaseHandler.getCurrentUserId(); // Die Methode sollte den aktuell angemeldeten Benutzer liefern.
;
        System.out.println(userId);

            if (userId == -1) {
                System.out.println("Fehler: Benutzer nicht gefunden.");
                return;
        }



            // Das Task-Objekt mit den Eingabedaten initialisieren
            task1.setTask(task);
            task1.setTaskDescription(description);
            task1.setDateCreated(sqlDate);
            task1.setUserid(userId);





            try {
                // Task in die Datenbank einfügen
                databaseHandler.addTask(task1);
                System.out.println("Task erfolgreich hinzugefügt.");
            } catch (SQLException e) {
                System.out.println("Fehler beim Hinzufügen des Tasks: " + e.getMessage());
                e.printStackTrace();
            }


    }
}

