package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseNavigationActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                showFragment(new HomeFragment());
                                return true;
                            case R.id.nav_bookmarks:
                                showFragment(new BookmarksFragment());
                                return true;
                            case R.id.nav_play:
                                showFragment(new PlayFragment());
                                return true;
                            case R.id.nav_leaderboard:
                                Intent intent = new Intent(BaseNavigationActivity.this, LeaderBoard.class);
                                startActivity(intent);
                                return true;
                            case R.id.nav_profile:
                                showFragment(new ProfileFragment());
                                return true;
                        }
                        return false;
                    }
                });

        // Wywołanie domyślnego fragmentu
        showFragment(new HomeFragment());
    }

    protected void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    protected abstract int getLayoutResourceId();

    protected abstract int getBottomNavigationViewId();

    protected abstract Fragment getHomeFragment();

    protected abstract Fragment getBookmarksFragment();

    protected abstract Fragment getPlayFragment();

    protected abstract Fragment getProfileFragment();

    protected abstract Fragment getLeaderBoardFragment();

    protected abstract int getFragmentContainerId();
}
