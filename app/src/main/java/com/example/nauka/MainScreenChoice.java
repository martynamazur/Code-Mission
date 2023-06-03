package com.example.nauka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.nauka.button.ButtonClickSound;
import com.example.nauka.notification.MyAlarmManager;
import com.example.nauka.singup.SignUp;

public class MainScreenChoice extends AppCompatActivity {

    private Button btnZaloguj;
    private  ButtonClickSound buttonClickSound;
    private Button btnZarejestruj;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MyAlarmManager myAlarmManager = new MyAlarmManager();

        // Wywołanie metody setAlarm()
        myAlarmManager.setAlarm(this);


        setContentView(R.layout.activity_main1);
        btnZaloguj = findViewById(R.id.btnZaloguj);
        btnZarejestruj = findViewById(R.id.btnZarejestruj);
        buttonClickSound = new ButtonClickSound(this);





        btnZarejestruj.setOnClickListener(view -> {
            buttonClickSound.playButtonClickSound();
            try {
                Intent intent = new Intent(MainScreenChoice.this, SignUp.class);
                startActivity(intent);
            } catch (Exception e) {
                System.out.println("blad");
                e.printStackTrace();

            }

        });


        btnZaloguj.setOnClickListener(view->{
            buttonClickSound.playButtonClickSound();
            try {
                Intent intent = new Intent(this,Zaloguj.class);
                startActivity(intent);
            } catch (Exception e) {
                System.out.println("blad");
                e.printStackTrace();

            }
        });
    }

}
