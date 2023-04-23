package com.example.nauka;

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
        setContentView(getLayoutResourceId());

        bottomNavigationView = findViewById(getBottomNavigationViewId());
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                showFragment(getHomeFragment());
                                return true;
                            case R.id.nav_bookmarks:
                                showFragment(getBookmarksFragment());
                                return true;
                            case R.id.nav_play:
                                showFragment(getPlayFragment());
                                return true;
                            case R.id.nav_leaderboard:
                                Intent intent = new Intent(BaseNavigationActivity.this, LeaderBoard.class);
                                startActivity(intent);
                                showFragment(getLeaderBoardFragment());
                                return true;
                            case R.id.nav_profile:
                                showFragment(getProfileFragment());
                                return true;
                        }
                        return false;
                    }
                });

        // Wywołanie domyślnego fragmentu
        showFragment(getHomeFragment());
    }

    protected abstract int getLayoutResourceId();

    protected abstract int getBottomNavigationViewId();

    protected abstract Fragment getHomeFragment();

    protected abstract Fragment getBookmarksFragment();

    protected abstract Fragment getPlayFragment();

    protected abstract Fragment getProfileFragment();
    protected abstract Fragment getLeaderBoardFragment();

    protected void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(getFragmentContainerId(), fragment)
                .commit();
    }

    protected abstract int getFragmentContainerId();
}
