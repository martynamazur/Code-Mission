package com.example.nauka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nauka.singup.SignUp;

public class MainScreenChoice extends AppCompatActivity {

    private Button btnZaloguj;
    Button btnZarejestruj;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnZaloguj = findViewById(R.id.btnZaloguj);
        btnZarejestruj = findViewById(R.id.btnZarejestruj);
        btnZaloguj.setText("Zaloguj mnie");
        btnZarejestruj.setText("Zarejestruj mnie");
        TextView txt = findViewById(R.id.textView2);
        txt.setText("Hello fucking world");

        btnZarejestruj.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainScreenChoice.this, SignUp.class);
                    startActivity(intent);
                } catch (Exception e) {
                    System.out.println("blad");
                    e.printStackTrace();

                }

            }

        });

    }


    public void onBtnClick(View view){

        //TextView txt = findViewById(R.id.textView2);
        //txt.setText("hehehhe");

        // do innego ekranu

        try {
            Intent intent = new Intent(this,Zaloguj.class);
            startActivity(intent);
        } catch (Exception e) {
            System.out.println("blad");
            e.printStackTrace();

        }


    }


}
