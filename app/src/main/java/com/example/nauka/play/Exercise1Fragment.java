package com.example.nauka.play;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.nauka.R;

public class Exercise1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public Exercise1Fragment() {
        // Pusty konstruktor publiczny jest wymagany
    }

    public static Exercise1Fragment newInstance(TaskModel task) {
        Exercise1Fragment fragment = new Exercise1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, task.getTaskTitle());
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            System.out.println("tu jestem");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise1, container, false);
    }
}
