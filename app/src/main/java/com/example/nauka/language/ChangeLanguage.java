package com.example.nauka.language;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;

import com.example.nauka.Zaloguj;

import java.util.ArrayList;
import java.util.List;

public class ChangeLanguage extends AppCompatActivity {
    String language_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LanguageManager languageManager = new LanguageManager(this);
        if (!languageManager.isLanguageSelected()){
            setContentView(R.layout.change_language_page);
            RecyclerView recyclerView = findViewById(R.id.language_recycler);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));


            LanguageModel polish = new LanguageModel("Polish",false,"flag_poland");
            LanguageModel english = new LanguageModel("English",false,"flag_united_kingdom");

            List<LanguageModel> languageList = new ArrayList<>();
            languageList.add(english);
            languageList.add(polish);



            LanguageAdapter languageAdapter = new LanguageAdapter(languageList, ChangeLanguage.this);


            languageAdapter.setOnLanguageClickListener(position -> {

                LanguageModel language = languageList.get(position);
                language_txt = language.getName();
                // a co jesli nie zaznacze niczego ?

            });
            recyclerView.setAdapter(languageAdapter);


            //jesli jest klikniety jakis checkbox to mozna przejsc dalej


            //nowa aktywnosc
            Button next = findViewById(R.id.next);
            next.setOnClickListener(v -> {

                if (language_txt != null){

                SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("language",language_txt);
                //Intent intent = new Intent(ChangeLanguage.this, WelcomePage.class);
                //startActivity(intent);
                }else{
                    // wyswietl komunikat o nie wybraniu jezyka
                    System.out.println("do zaimlementowania");
                }

            });




        }else{
            Intent intent = new Intent(ChangeLanguage.this, Zaloguj.class);
            startActivity(intent);
        }


}}
