package com.example.nauka.profilesettings;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.R;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            EditText editTextTextPassword = findViewById(R.id.editPassword);

            setContentView(R.layout.settings_change_password_page_step1);


        editTextTextPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sprawdź aktualny stan widoku
                if (editTextTextPassword.isSelected()) {
                    // Hasło jest widoczne, więc zmień na ukryte
                    editTextTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // Hasło jest ukryte, więc zmień na widoczne
                    editTextTextPassword.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                }

                // Zmień stan widoku
                editTextTextPassword.setSelected(!editTextTextPassword.isSelected());
            }
        });
    }
}
