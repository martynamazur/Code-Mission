package com.example.nauka;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
    private final Connection connection;


    //konstruktor
    public DBManager(Connection connection) {
        this.connection = connection;
    }





    public boolean findUser(String email, String hash){
        String query = "SELECT EXISTS(SELECT 1 FROM informacje WHERE email = ? OR login = ? ) as result;";
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

    public boolean doesUserExist(String information){

        String query = "SELECT * FROM informacje WHERE email = ? OR login= ? ;";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, information);
            preparedStatement.setString(2, information);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Połączenie z bazą danych zostało nawiązane poprawnie.");
            // next zwraca true, lub false jesli istnieje kolejny element
            // jesli jest rozne oznacza ze nie ma niczego
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


}



}

