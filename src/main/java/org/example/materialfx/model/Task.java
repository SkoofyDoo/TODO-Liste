package org.example.materialfx.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Task {

    private int userID;
    private Timestamp dateCreated;
    private String task;
    private String taskDescription;


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Task() {
    }


    public Task(int userID, String task, String taskDescription, Timestamp dateCreated) {

        this.userID = userID;
        this.task = task;

        this.taskDescription = taskDescription;
        this.dateCreated = dateCreated;
    }



    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }




}
