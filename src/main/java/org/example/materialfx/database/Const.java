package org.example.materialfx.database;

import java.util.Date;

public class Const {

    public static final String USERS_TABLE= "users";
    public static final String TASKS_TABLE= "tasks";

    // USERS Table

    public static final String USERS_ID= "userid";
    public static final String USERS_FIRSTNAME= "firstname";
    public static final String USERS_LASTNAME= "lastname";
    public static final String USERS_USERNAME= "username";
    public static final String USERS_PASSWORD= "password";
    public static final String USERS_GENDER= "gender";

    // TASKS Table

    public static final String TASKS_ID = "taskid";
    public static final String TASKS_USERID = "userid";
    public static final String TASKS_NAME = "task";
    public static final String TASKS_DATE = "datecreated";
    public static final String TASKS_DESCRIPTION= "description";
}
