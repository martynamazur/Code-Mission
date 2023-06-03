package com.example.nauka.language;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;

import com.example.nauka.Zaloguj;
import com.example.nauka.profilesettings.Settings;
import com.example.nauka.walkrought.Walkrough;

import java.util.ArrayList;
import java.util.List;

public class ChangeLanguage extends AppCompatActivity {
    String language_txt;

    private SharedPreferences sharedPreferences;
    private TextView errorMessagePickLanguage;
    private LanguageAdapter languageAdapter;
    private  Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LanguageManager languageManager = new LanguageManager(this);

        errorMessagePickLanguage = findViewById(R.id.errorMessagePickLanguage);
        next = findViewById(R.id.next);


        LanguageModel polish = new LanguageModel("Polish",false,"flag_poland");
        LanguageModel english = new LanguageModel("English",false,"flag_united_kingdom");

        List<LanguageModel> languageList = new ArrayList<>();
        languageList.add(english);
        languageList.add(polish);

        languageAdapter = new LanguageAdapter(languageList, ChangeLanguage.this);

        boolean isFirstRun = sharedPreferences.getBoolean("firstRun", true);



        if (!languageManager.isLanguageSelected()){

            setContentView(R.layout.change_language_page);
            RecyclerView recyclerView = findViewById(R.id.language_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            languageAdapter.setOnLanguageClickListener(position -> {

                LanguageModel language = languageList.get(position);
                language_txt = language.getName();
            });

            recyclerView.setAdapter(languageAdapter);


            //jesli jest klikniety jakis checkbox to mozna przejsc dalej
            //nowa aktywnosc


            next.setOnClickListener(v -> {

                //spr czy przypadkiem nic nie wybrano
                if (language_txt != null){

                sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("language",language_txt);

                // jesli jest to pierwsze uzycie i nie ma wybranego języka bo ktos mogł wlaczyc i wyłączyć aplikacje

                Intent intent = new Intent(ChangeLanguage.this, Walkrough.class);
                startActivity(intent);

                }else{
                    // wyswietl komunikat o nie wybraniu jezyka
                    System.out.println("do zaimlementowania");
                }

            });



        //jesli jest wybrany jezyk
        }else{


            if (sharedPreferences.getString("singIn","").equals("true")){
                Intent intent = new Intent(ChangeLanguage.this, Settings.class);
                startActivity(intent);
            }else{
                Intent intent = new Intent(ChangeLanguage.this, Zaloguj.class);
                startActivity(intent);
            }



        }


}}
