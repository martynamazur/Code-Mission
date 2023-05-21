package com.example.nauka.accountVerification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.R;
import com.example.nauka.Zaloguj;

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
