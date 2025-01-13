package org.example.materialfx.database;

import java.sql.Connection;
import java.sql.SQLException;

public class DB_Handler extends DBConfig{
    Connection dbconnection;

    public Connection getDbconnection() throws ClassNotFoundException, SQLException {
        String conntectionString = "jbdc:mysql://"+dbHost+":"+getPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection = java.sql.DriverManager.getConnection(conntectionString,dbUser,dbPass);
        return dbconnection;
    }
}


