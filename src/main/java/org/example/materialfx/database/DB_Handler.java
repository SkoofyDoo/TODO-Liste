package org.example.materialfx.database;

import org.example.materialfx.model.Task;
import org.example.materialfx.model.User;

import java.sql.*;


import static org.example.materialfx.database.Const.*;

public class DB_Handler extends DBConfig {
    Connection getDbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String conntectionString = "jdbc:mysql://" + dbHost + ":" + getPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        getDbConnection = java.sql.DriverManager.getConnection(conntectionString, dbUser, dbPass);

        return getDbConnection;
    }

    public void signUpUser(User user) throws SQLException {
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + USERS_FIRSTNAME + "," + USERS_LASTNAME + ", "
                + USERS_USERNAME + ", " + USERS_PASSWORD + ", " + USERS_GENDER + ")" + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();


            System.out.println("User Signed Up");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void addTask(Task task) throws SQLException {
        String insert = "INSERT INTO " + TASKS_TABLE + "(" + TASKS_USERID + "," + TASKS_TASK + "," + TASKS_DATE + ", "
                + TASKS_DESCRIPTION + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setInt(1, task.getUserID());
            preparedStatement.setString(2, task.getTask());
            preparedStatement.setTimestamp (3, task.getDateCreated());
            preparedStatement.setString(4, task.getTaskDescription());


            preparedStatement.executeUpdate();

            System.out.println(String.format("Task %s added to user %s", task.getTask(), task.getUserID()));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = null;


        if (!user.getUsername().equals("") || !user.getPassword().equals("")) {

            // SELECT * FROM users, wo username = "USERS_NAME" und password="USERS_PASSWORT"
            String query = "SELECT * FROM " + USERS_TABLE + " WHERE " +
                    USERS_USERNAME + "= ?" + " AND " + USERS_PASSWORD + "=?";


            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

        } else {
            System.out.println("Bitte Ihre Daten eingeben");
        }
        return resultSet;
    }
}