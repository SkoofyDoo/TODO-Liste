package org.example.materialfx.database;

import org.example.materialfx.model.Task;
import org.example.materialfx.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String insert = "INSERT INTO " + TASKS_TABLE + "(" + TASKS_NAME + "," + TASKS_USERID + "," + TASKS_DESCRIPTION + ", "
                + TASKS_DATE + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);


            preparedStatement.setString(1, task.getTask());
            preparedStatement.setInt(2, task.getUserid());
            preparedStatement.setString(3, task.getTaskDescription());
            preparedStatement.setDate(4, task.getDateCreated());

            preparedStatement.executeUpdate();

            System.out.println(String.format("Task %s added to user %s", task.getTask(), task.getUserid()));

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        getCurrentUserId();
    }


    public ResultSet getUser(User user) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = null;


        if (!user.getUsername().equals("") || !user.getPassword().equals("")) {

            // SELECT * FROM users, wo username = "USERS_NAME" und password="USERS_PASSWORT"
            String query = "SELECT * FROM " + USERS_TABLE + " WHERE " +
                    USERS_USERNAME + "= ?" + " AND " + USERS_PASSWORD + "=?";


            //String id = "ALTER TABLE " + TASKS_TABLE + " ADD CONSTRAINT " + TASKS_USERID + " FOREIGN KEY" + USERS_ID + "REFERENCES" +  USERS_ID;

            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            resultSet = preparedStatement.executeQuery();

        } else {
            System.out.println("Bitte Ihre Daten eingeben");
        }

        return resultSet;
    }

    public int getCurrentUserId() {
        int userId = -1; // Standardwert, falls kein Benutzer gefunden wird
//        String query = "SELECT " + USERS_ID + " FROM " + USERS_TABLE + " WHERE " + USERS_USERNAME + " = ?";
//
//
//        try {
//
//            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
//            preparedStatement.setInt(1, userid);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                userId = resultSet.getInt(USERS_ID);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        return userId;

        List<Integer> userIds = new ArrayList<>(); // Список для хранения userId
        String query = "SELECT " + USERS_ID + " FROM " + USERS_TABLE; // Запрос для получения всех userId

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) { // Цикл для чтения всех userId
                userId = resultSet.getInt(USERS_ID);
                userIds.add(userId); // Сохранение userId в списке
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userId;

    }


}
