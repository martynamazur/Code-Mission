package com.example.nauka.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.example.nauka.R;
import com.example.nauka.profilesettings.Settings;

public class MyProfileFragment extends Fragment {

    ImageButton btnSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        btnSettings = view.findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Settings.class);
            startActivity(intent);
        });

        return view;
    }
}
