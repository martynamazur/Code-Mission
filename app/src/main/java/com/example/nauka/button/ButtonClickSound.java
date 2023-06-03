package com.example.nauka.button;


import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;

import com.example.nauka.R;

public class ButtonClickSound extends AppCompatButton implements View.OnClickListener {
    private MediaPlayer mediaPlayer;

    public ButtonClickSound(Context context) {
        super(context);
        init();
    }

    public ButtonClickSound(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonClickSound(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setOnClickListener(this);
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.click_sound_basic);
    }

    @Override
    public void onClick(View v) {
        playButtonClickSound();
        // Tutaj dodaj kod obsługi kliknięcia przycisku
    }

    public void playButtonClickSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}
