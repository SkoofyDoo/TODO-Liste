package org.example.materialfx.model;

import java.sql.Date;

public class Task {

    private Date dateCreated;
    private String task;
    private String taskDescription;
    private int userid;

    public Task() {
    }


    public Task(int userid, String task, String taskDescription, Date dateCreated) {

        this.task = task;
        this.userid = userid;
        this.taskDescription = taskDescription;
        this.dateCreated = dateCreated;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
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
