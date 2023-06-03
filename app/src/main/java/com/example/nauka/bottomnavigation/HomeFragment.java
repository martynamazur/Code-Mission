package com.example.nauka.bottomnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.Message;
import com.example.nauka.MessageAdapter;
import com.example.nauka.R;

import java.util.List;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*
        DataBaseHelper db = new DataBaseHelper(getActivity()); // Użyj getActivity() zamiast HomeFragment.this
        List<Message> m = db.loadMessagesFromDatabase();

        try{
            MessageAdapter messageAdapter = new MessageAdapter(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
         */


        // Pozostała część kodu, jeśli istnieje

        return view;
    }
}