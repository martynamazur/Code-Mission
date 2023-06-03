package com.example.nauka.profilesettings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;
import com.example.nauka.Zaloguj;
import com.example.nauka.language.ChangeLanguage;
import com.example.nauka.linkedAccounts.LinkedAccount;

import org.w3c.dom.Text;

public class Settings extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_page);

        Button changePassword = findViewById(R.id.changePassword);
        Button changeEmail = findViewById(R.id.changeEmail);
        Button manageConnectedAccounts = findViewById(R.id.manageConnectedAccounts);
        Button manageAgreements = findViewById(R.id.manageAgreements);

        Switch dayNightTheme = findViewById(R.id.dayNightTheme);
        Switch learningReminder = findViewById(R.id.learningReminder);
        Switch commentsReplyNotification = findViewById(R.id.commentsReplyNotification);
        Switch newMessageNotification = findViewById(R.id.newMessageNotification);

        TextView changeLanguage = findViewById(R.id.changeLanguage);
        TextView txtDay = findViewById(R.id.txtDay);
        TextView txtNight = findViewById(R.id.txtNight);

        TextView textViewSignOut = findViewById(R.id.textViewSignOut);


        changePassword.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, ConfirmPassword.class);
            startActivity(intent);
            }
        );


        changeEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, ChangeEmail.class);
            startActivity(intent);
        }
        );

        manageConnectedAccounts.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, ConnectedAccounts.class);
            startActivity(intent);
        }
        );

        manageAgreements.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, ManageAgreement.class);
            startActivity(intent);
        }
        );



        textViewSignOut.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            Intent intent = new Intent(Settings.this, Zaloguj.class);
            startActivity(intent);
        }
        );

        // sharedpref problem
        changeLanguage.setOnClickListener(v->{
            try{
                Intent intent = new Intent(Settings.this, ChangeLanguage.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("heheh debil");
            }


        });

        manageConnectedAccounts.setOnClickListener(v->{
            try{
                Intent intent = new Intent(Settings.this, LinkedAccount.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("heheh debil jestes");
            }

        });


        manageAgreements.setOnClickListener(v->{
            try{
                Intent intent = new Intent(Settings.this, ManageAgreements.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("kolejny debil");
            }
        });
    }
}
