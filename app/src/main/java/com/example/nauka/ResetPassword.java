package com.example.nauka;

import static java.sql.DriverManager.getConnection;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public void onClickBtnReset(View view) {
        String loginInfo = loginInformation.getText().toString().trim();

    }


}
