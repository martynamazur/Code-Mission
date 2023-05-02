package com.example.nauka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationComplited extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification_complited_page);


        Button btnNextNav = findViewById(R.id.btnNextNav);
        btnNextNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerificationComplited.this, Zaloguj.class);
                startActivity(intent);

            }
        });

    }}
