package com.example.nauka;

import static java.sql.DriverManager.getConnection;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    private EditText loginInformation;
    private TextView validation_mess;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

        validation_mess = findViewById(R.id.validation_mess);
        TextView txtBlocktext = findViewById(R.id.textBlock);
        loginInformation = findViewById(R.id.editEmailReset);
        Button btnResetuj = findViewById(R.id.btnResetuj);

        validation_mess.setVisibility(View.INVISIBLE);
        txtBlocktext.setText("Proszę wpisz swój email lub username");
        loginInformation.setHint("Email / Username");

        //Button btnSendAgainMessage = findViewById(R.id.btnSendAgain);
        btnResetuj.setText("Reset");




    }
    public void onClickBtnReset(View view){

        // sprawdzic czy email lub username znajduje sie w bazie danych
        //wywolanie funckji


        Connect connect = new Connect();
        //connect.connect();
        if (connect.getConnection() == null){
            System.out.println("ew");
        }

        DBManager dbManager = new DBManager(connect.getConnection());

        System.out.println(loginInformation.getText());
        String inf = String.valueOf(loginInformation.getText());
        System.out.println(String.valueOf(loginInformation));
        System.out.println(inf);
        boolean doesExists = dbManager.doesUserExist(inf);
        System.out.println("TESTOWANKO"+doesExists);

        if( doesExists){
            try {
                Intent intent = new Intent(this,ChangePasswordAuthentication.class);
                startActivity(intent);
            }catch (Exception e){
                System.out.println("haha fuck it");
            }
        }else{
            // wyswietl informacje
            validation_mess.setVisibility(View.VISIBLE);


        }
        connect.disconnect();




    }
}
