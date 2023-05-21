package com.example.nauka.walkrought;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.nauka.MainScreenChoice;
import com.example.nauka.R;
import com.example.nauka.Zaloguj;

import java.util.ArrayList;
import java.util.List;

public class Walkrough extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private SlideAdapter slideAdapter;
    private List<Slide> slideList;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkrrough_layout);

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);
        close = findViewById(R.id.buttonClose);

        slideList = new ArrayList<>();
        slideList.add(new Slide(getString(R.string.welcome_title1), getString(R.string.welcome_message1),"welcome_screen1",false));
        slideList.add(new Slide(getString(R.string.welcome_title2), getString(R.string.welcome_message2),"welcome_screen2",false));
        slideList.add(new Slide(getString(R.string.welcome_title3), getString(R.string.welcome_message3),"welcome_screen3",false));
        slideList.add(new Slide(getString(R.string.welcome_title4), getString(R.string.welcome_message4),"welcome_screen4",true));
        slideAdapter = new SlideAdapter(this, slideList);
        viewPager.setAdapter(slideAdapter);

        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        close.setOnClickListener(view -> {
            try {
                Intent intent = new Intent(Walkrough.this, MainScreenChoice.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                startActivity(intent);
            } catch (Exception e) {
                System.out.println("blad");
                e.printStackTrace();

            }
        });
    }



    private void addDotsIndicator(int position) {
        TextView[] dots = new TextView[slideList.size()];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText("•");
            dots[i].setTextSize(30);
            dots[i].setTextColor(ContextCompat.getColor(this, R.color.dotInactive));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(ContextCompat.getColor(this, R.color.dotActive));
        }
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

}
