package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.sql.Connection;

public class Zaloguj extends AppCompatActivity {

    String email;
    String password;


    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaloguj);

        TextView txtEmail =  findViewById(R.id.email);
        txtEmail.setText("Email: ");
        EditText editEmail = findViewById(R.id.editEmail);

        TextView txtPassowrd = findViewById(R.id.editPassoword);
        txtPassowrd.setText("Password: ");
        EditText editPassword = findViewById(R.id.password);



        Button btnZaloguj = findViewById(R.id.btnSignIn);
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

        /*
        Connect connect = new Connect();
        connect.connect();
        Connection connection = connect.getConnection();
        DBManager dbManager = new DBManager(connection);



        if(dbManager.findUser(email,password)){
            // jesli zwroci true idze do kolejnej aktywnosci
            Intent intent = new Intent(this, HomePage.class);
            startActivity(intent);
            System.out.println("tutu");
            //jesli nie to wraca i wyswietla ostzrezenie
        }else{
            Snackbar.make(view,"Błędne dane logowania !", Snackbar.LENGTH_SHORT).show();
        }

         */

        try{
            Intent intent = new Intent(this,HomePage.class);
            startActivity(intent);
        }catch (Exception e)
        {
            System.out.println("ups");
        }

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
