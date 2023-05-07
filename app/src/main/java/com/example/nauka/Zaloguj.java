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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.bottomnavigation.MainActivityTransition;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.sql.Connection;

public class Zaloguj extends AppCompatActivity {

    String email;
    String password;

    Button btnZaloguj;
    EditText editPassword;
    EditText editEmail;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaloguj);


        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.password);


        btnZaloguj = findViewById(R.id.btnSignIn);
        //Button btnZarejestruj = findViewById(R.id.btnCreateAccount);
        btnZaloguj.setText("Zaloguj");
        TextView forgottenPassword = findViewById(R.id.forgottenPassword);
        forgottenPassword.setText(" Did you forget your password ?");


        TextView contiuneGoogle = findViewById(R.id.continueGoogle);
        TextView continueFb = findViewById(R.id.continueFb);
        contiuneGoogle.setText("Kontynuuj z Google");
        continueFb.setText("Kontynuuj z Facebook");

    }
    public void signIn(View view){

        EditText txtEmail =  findViewById(R.id.editEmail);
        EditText txtPassowrd = findViewById(R.id.password);
        String email = txtEmail.getText().toString();
        //String password = txtPassowrd.getText().toString();
        // do testow
        String password ="$2a$10$zG6W5R8erFGc2n1lEY5b5el1MJSEeLx40yoPfA24Mn2DngB8mtvAy";
        //HashPassword hp = new HashPassword(password);



        btnZaloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SingUp_DataValidation singUp_dataValidation = new SingUp_DataValidation(editEmail.getText().toString(),editPassword.getText().toString());
                DataBaseHelper db = new DataBaseHelper(Zaloguj.this);
                if(db.isEmailExists(editEmail.getText().toString())){



                    if (db.singInValidation(editPassword.getText().toString(),editEmail.getText().toString())){

                        System.out.println(editEmail.getText().toString() +""+editPassword.getText().toString());
                        try{
                            Intent intent = new Intent(Zaloguj.this, MainActivityTransition.class);
                            startActivity(intent);


                            /*
                                 MECHANIZM SESJI
                                 Sesja to czas, w którym użytkownik jest aktywny w Twojej aplikacji, a
                                 aplikacja może przechowywać informacje o tym użytkowniku, takie jak ID,
                                 nazwa użytkownika, adres e-mail itp.
                             */

                            // Uzyskaj obiekt SharedPreferences dla nazwy "myPrefs"
                            SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

                            // Edytuj SharedPreferences
                            SharedPreferences.Editor editor = prefs.edit();

                            // Dodaj wartość

                            editor.putString("email", email);
                            editor.putString("id", String.valueOf(db.getIdByEmail(email)));

                            // Zapisz zmiany
                            editor.apply();


                        }catch (Exception e)
                        {
                            System.out.println("ups");
                        }

                    }else{
                        System.out.println("nie poprawne haslo");
                        System.out.println(editPassword.getText().toString());
                        // wyswietlic komunikat, zmienic widocznosc
                    }

                }else{
                    System.out.println("konto nie istnieje");
                    System.out.println(editEmail.getText().toString());
                    System.out.println(editPassword.getText().toString());
                    // wyswietlic komunikat, zmienic widocznosc
                }



            }
        });


        // validacja wpisanych danych
        // funckja spr czy taki uzytkownik istnieje




    }

    public void resetPassword(View view){
        try{
        Intent intent = new Intent(this,ResetPassword.class);
        startActivity(intent);
    }catch (Exception e)
        {
            System.out.println("ups");
        }
    }



}
