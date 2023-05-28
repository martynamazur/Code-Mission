package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import com.example.nauka.bottomnavigation.MainActivityTransition;
import com.example.nauka.resetPassword.ResetPassword;


public class Zaloguj extends AppCompatActivity {



    private Button btnZaloguj;
    private EditText editPassword;
    private EditText editEmail;
    private TextView messageisEmailExists;
    private TextView messageisPasswordRight;



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaloguj);



        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.password);
        messageisEmailExists = findViewById(R.id.messageisEmailExists);
        messageisPasswordRight = findViewById(R.id.messageisPasswordRight);
        messageisPasswordRight.setVisibility(View.INVISIBLE);
        messageisEmailExists.setVisibility(View.INVISIBLE);
        btnZaloguj = findViewById(R.id.btnSignIn);


        TextView contiuneGoogle = findViewById(R.id.continueGoogle);
        TextView continueFb = findViewById(R.id.continueFb);


    }
    public void signIn(View view){

        EditText txtEmail =  findViewById(R.id.editEmail);
        EditText txtPassowrd = findViewById(R.id.password);
        String email = txtEmail.getText().toString();



        btnZaloguj.setOnClickListener(v -> {

            DataBaseHelper db = new DataBaseHelper(Zaloguj.this);
            if(db.isEmailExists(editEmail.getText().toString())){

                showMessageErrorPassword();

                if (db.singInValidation(editPassword.getText().toString(),editEmail.getText().toString())){

                    //System.out.println(editEmail.getText().toString() +""+editPassword.getText().toString());

                    Intent intent = new Intent(Zaloguj.this, MainActivityTransition.class);
                    startActivity(intent);

                    /*
                         MECHANIZM SESJI
                         Sesja to czas, w którym użytkownik jest aktywny w Twojej aplikacji, a
                         aplikacja może przechowywać informacje o tym użytkowniku, takie jak ID,
                         nazwa użytkownika, adres e-mail itp.
                     */


                    SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("email", email);
                    editor.putString("id", String.valueOf(db.getIdByEmail(email)));
                    editor.apply();

                }else{

                    System.out.println("nie poprawne haslo");
                    System.out.println(editPassword.getText().toString());
                    // wyswietlic komunikat, zmienic widocznosc
                    showMessageErrorPassword();

                }

            }else{
                System.out.println("konto nie istnieje");
                showMessageErrorEmail();
                System.out.println(editEmail.getText().toString());
                System.out.println(editPassword.getText().toString());
                // wyswietlic komunikat, zmienic widocznosc
            }

        });
    }

    public void showMessageErrorEmail(){
        messageisPasswordRight.setVisibility(messageisPasswordRight.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
    }
    public void showMessageErrorPassword(){
        messageisPasswordRight.setVisibility(messageisPasswordRight.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);

    }

    public void resetPassword(View view){

        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);

    }

}
