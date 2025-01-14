package org.example.materialfx.model;

public class Task {

    public Task() {
    }

    public Task(long dateCreated, String taskDescription, String task) {
        this.dateCreated = dateCreated;
        this.taskDescription = taskDescription;
        this.task = task;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
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

    private long dateCreated;
    private String taskDescription;
    private String task;


}
