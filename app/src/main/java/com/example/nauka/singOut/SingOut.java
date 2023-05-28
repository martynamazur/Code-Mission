package com.example.nauka.singOut;
import android.content.Context;
import android.content.SharedPreferences;

public class SingOut {

    private Context context;
    private SharedPreferences sharedPreferences;

    public SingOut(Context context) {
        this.context = context;
    }

    // Czyszczenie po wylogowaniu preferencji
    public void signOut() {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
}
