package org.example.materialfx.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.materialfx.database.Const.*;

public class DB_Handler extends DBConfig{
    Connection getDbCconnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String conntectionString = "jdbc:mysql://"+dbHost+":"+getPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        getDbCconnection = java.sql.DriverManager.getConnection(conntectionString,dbUser,dbPass);

        return getDbCconnection;
    }

    public void signUpUser(String firstName, String lastName, String userName,
                           String password, String gender) throws SQLException{
        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + USERS_FIRSTNAME + "," + USERS_LASTNAME + ", "
                + USERS_USERNAME + ", " + USERS_PASSWORD + ", " + USERS_GENDER + ")" + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, gender);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            System.out.println("User Signed Up");

        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }




}


