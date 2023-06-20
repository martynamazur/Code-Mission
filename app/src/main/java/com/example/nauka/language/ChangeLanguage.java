package com.example.nauka.language;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import java.util.Locale;

public class ChangeLanguage extends AppCompatActivity {
    String language_txt;

    private SharedPreferences sharedPreferences;
    private TextView errorMessagePickLanguage;
    private LanguageAdapter languageAdapter;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LanguageManager languageManager = new LanguageManager(this);
        sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);

        // Sprawdź, czy język został już wybrany
        if (!languageManager.isLanguageSelected()) {
            setContentView(R.layout.change_language_page);
            RecyclerView recyclerView = findViewById(R.id.language_recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            LanguageModel polish = new LanguageModel("Polish", false, "flag_poland");
            LanguageModel english = new LanguageModel("English", false, "flag_united_kingdom");

            List<LanguageModel> languageList = new ArrayList<>();
            languageList.add(english);
            languageList.add(polish);

            languageAdapter = new LanguageAdapter(languageList, ChangeLanguage.this);

            languageAdapter.setOnLanguageClickListener(position -> {
                LanguageModel language = languageList.get(position);
                language_txt = language.getName();
            });

            recyclerView.setAdapter(languageAdapter);

            next = findViewById(R.id.next);
            next.setOnClickListener(v -> {
                if (language_txt != null) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("language", language_txt);
                    editor.apply();

                    // Ustaw nowy język w aplikacji
                    setLocale(language_txt);

                    // Przejdź do kolejnej aktywności
                    Intent intent = new Intent(ChangeLanguage.this, Walkrough.class);
                    startActivity(intent);
                } else {
                    // Wyświetl komunikat o nie wybraniu języka
                    System.out.println("do zaimplementowania");
                }
            });
        } else {
            // Jeśli język został już wybrany, przejdź do odpowiedniej aktywności
            if (sharedPreferences.getString("singIn", "").equals("true")) {
                Intent intent = new Intent(ChangeLanguage.this, Settings.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(ChangeLanguage.this, Zaloguj.class);
                startActivity(intent);
            }
        }
    }

    // Metoda do ustawiania języka aplikacji

    // Metoda do ustawiania języka aplikacji
    private void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);

        Context context = createConfigurationContext(configuration);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());

        // Zapisz ustawienia języka w preferencjach
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", language);
        editor.apply();
    }
}
