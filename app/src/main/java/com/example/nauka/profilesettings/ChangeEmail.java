package com.example.nauka.profilesettings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;

public class ChangeEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.change_email_page);

        TextView currentEmail = findViewById(R.id.currentEmail);
        TextView errorMessageEmailExist = findViewById(R.id.errorMessageEmailExist);
        EditText newEmail  = findViewById(R.id.editTextTextEmailAddress);
        Button buttonNextConfirm = findViewById(R.id.buttonNextConfirm);
        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String nowyEmail = newEmail.getText().toString();

        String email = prefs.getString("email", "");
        System.out.println(" czy sie zapisalo"+email);


        DataBaseHelper db = new DataBaseHelper(ChangeEmail.this);
        currentEmail.setText(email);


        buttonNextConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gdzie wraca ? co robi ?

                if (!nowyEmail.equals(email)){
                    // jesli jest rozny od obecnego emaila
                    if (db.isEmailExists(nowyEmail)) {
                        //jesli jest juz przypisany do innego konta
                        System.out.println("zmienic widocznosc komunikatu juz przypisany do innego konta");
                    }else{
                        // make an update
                        String id = prefs.getString("id","");
                        boolean sk = db.changeEmail(id,nowyEmail);
                        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("email", nowyEmail);
                        editor.apply();


                        //to spr wywalic pozniej

                        if (sk){
                            System.out.println("nie ma problemu");
                        }else{
                            System.out.println("jest problem");
                        }

                        Intent intent = new Intent(ChangeEmail.this, ChangePassword.class);
                        startActivity(intent);

                    }

                }else{
                    // wyswietli inf ze wpisal uzytkownik ten sam email ?
                    System.out.println("zmienic widocznosc komunikatu");
                }


            }}
        );

    }
}
