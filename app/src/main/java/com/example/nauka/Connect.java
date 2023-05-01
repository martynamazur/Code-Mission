package com.example.nauka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    private Connection connection;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            System.out.println("Connected to SQLite database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
