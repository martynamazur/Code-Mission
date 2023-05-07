package com.example.nauka.profilesettings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;

public class ConfirmPassword extends AppCompatActivity {

    Button buttonNavConfirm;
    TextView resetPassword;
    TextView errorMessageIncorectPassword;
    EditText editPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_change_password_page_step1);

        errorMessageIncorectPassword = findViewById(R.id.errorMessageIncorectPassword);
        resetPassword = findViewById(R.id.resetPassword);
        buttonNavConfirm = findViewById(R.id.buttonNavConfirm);
        editPassword = findViewById(R.id.editPassword);


        //Podglad hasla
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sprawdź aktualny stan widoku
                if (editPassword.isSelected()) {
                    // Hasło jest widoczne, więc zmień na ukryte
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // Hasło jest ukryte, więc zmień na widoczne
                    editPassword.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                }

                // Zmień stan widoku
                editPassword.setSelected(!editPassword.isSelected());
            }
        });


        buttonNavConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

                String accountId = prefs.getString("id", "");
                System.out.println(accountId+"Test id");
                System.out.println(editPassword.getText().toString()+"test haslo");

                DataBaseHelper db = new DataBaseHelper(ConfirmPassword.this);

                if(db.comparePasswordsById(editPassword.getText().toString(),accountId)){
                    Intent intent = new Intent(ConfirmPassword.this,ChangePassword.class );
                    startActivity(intent);
                }else{
                    // wyswietli sie komunika ze haslo sie nie zgadza
                    System.out.println("do zaimplementowania");
                }

                }

            }
        );
    }




}
