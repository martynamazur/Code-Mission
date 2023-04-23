package com.example.nauka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private Connection connection;

    //konstruktor
    public DBManager(Connection connection) {
        this.connection = connection;
    }

    public boolean findUser(String email, String hash){
        String query = "SELECT * FROM informacje WHERE email = ? AND hash = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // w miejsce ? wstawiam odpowiednie wartosci zmiennych i nie musze sie martwic
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hash);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // użytkownik o podanym emailu i haśle został znaleziony
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // użytkownik o podanym emailu i haśle nie został znaleziony
        return false;
    }


}

