package com.example.nauka.bottomnavigation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.Message;
import com.example.nauka.MessageAdapter;
import com.example.nauka.R;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private List<Message> m = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy 'at' HH:mm:ss z", Locale.getDefault());

        m = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("information_messages").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String headline = snapshot.child("headline").getValue(String.class);
                        String information = snapshot.child("information").getValue(String.class);
                        String postDate = snapshot.child("post_date").getValue(String.class);
                        String postExpire = snapshot.child("post_expire").getValue(String.class);

                        try {
                            assert postDate != null;
                            assert postExpire != null;
                            m.add(new Message(headline, information, dateFormat.parse(postDate), dateFormat.parse(postExpire)));
                            System.out.println("pustki" + m);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        // Wyświetlenie pobranych wartości
                        Log.d("firebase", "Headline: " + headline);
                        Log.d("firebase", "Information: " + information);
                        Log.d("firebase", "Post Date: " + postDate);
                        Log.d("firebase", "Post Expire: " + postExpire);
                        Log.d("firebase", "------------------");
                    }
                    messageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("firebase", "Error getting data", databaseError.toException());
            }
        });

        recyclerView = view.findViewById(R.id.message_recycler_view);
        messageAdapter = new MessageAdapter(m);
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
