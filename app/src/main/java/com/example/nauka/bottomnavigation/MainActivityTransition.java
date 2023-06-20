package com.example.nauka.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityTransition extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    BookMarksFragment bookmarksFragment = new BookMarksFragment();
    LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
    MyProfileFragment myProfileFragment = new MyProfileFragment();
    PlayFragment playFragment = new PlayFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("tutaj 3");


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        // replace the activity with the home fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;

                    case R.id.nav_bookmarks:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, bookmarksFragment).commit();
                        return true;

                    case R.id.nav_play:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, playFragment).commit();
                        return true;

                    case R.id.nav_leaderboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, leaderboardFragment).commit();
                        return true;

                    case R.id.nav_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, myProfileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
