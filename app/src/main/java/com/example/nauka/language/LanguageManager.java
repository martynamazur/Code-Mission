package com.example.nauka.language;

import android.content.Context;
import android.content.SharedPreferences;

public class LanguageManager {
    private static final String PREF_LANGUAGE_SELECTED = "language_selected";
    private SharedPreferences preferences;

    public LanguageManager(Context context) {
        preferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public boolean isLanguageSelected() {
        return preferences.getBoolean(PREF_LANGUAGE_SELECTED, false);
    }

    public void saveLanguageSelection() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREF_LANGUAGE_SELECTED, true);
        editor.apply();
    }
}
