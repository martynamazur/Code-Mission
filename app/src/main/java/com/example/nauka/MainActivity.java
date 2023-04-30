package com.example.nauka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnZaloguj = findViewById(R.id.btnZaloguj);
        Button btnZarejestruj = findViewById(R.id.btnZarejestruj);
        btnZaloguj.setText("Zaloguj mnie");
        btnZarejestruj.setText("Zarejestruj mnie");
        TextView txt = findViewById(R.id.textView2);
        txt.setText("Hello fucking world");

    }


    @SuppressLint("SetTextI18n")
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
