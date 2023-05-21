package com.example.nauka.walkrought;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.nauka.MainScreenChoice;
import com.example.nauka.R;
import com.example.nauka.Zaloguj;

import java.util.List;

public class SlideAdapter extends PagerAdapter {

    private Context context;
    private List<Slide> slideList;

    public SlideAdapter(Context context, List<Slide> slideList) {
        this.context = context;
        this.slideList = slideList;
    }

    @Override
    public int getCount() {
        return slideList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View slideLayout = inflater.inflate(R.layout.slide_layout, container, false);

        TextView textViewTitle = slideLayout.findViewById(R.id.textViewTitle);
        TextView textViewDescription = slideLayout.findViewById(R.id.textViewDescription);

        Slide slide = slideList.get(position);

        textViewTitle.setText(slide.getTitle());
        textViewDescription.setText(slide.getDescription());

        ImageView imageViewSlide = slideLayout.findViewById(R.id.imageViewSlide);

        String imageName = slide.getImage();
        int resourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        imageViewSlide.setImageResource(resourceId);

        container.addView(slideLayout);

        // Dodatkowy przycisk na ostatnim slajdzie
        if (position == getCount() - 1) {
            Button buttonNext = slideLayout.findViewById(R.id.buttonNext);
            buttonNext.setVisibility(View.VISIBLE);
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainScreenChoice.class);
                    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

        return slideLayout;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

