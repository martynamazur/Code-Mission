package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.nauka.profilesettings.ChangePassword;
import com.example.nauka.profilesettings.Settings;

public class MyProfile extends AppCompatActivity {

    ImageButton btnSettings;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile_page);

        // Ustawienia
        btnSettings = findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(MyProfile.this, Settings.class);
                                               startActivity(intent);
                                           }
                                       }
        );

    }
}

