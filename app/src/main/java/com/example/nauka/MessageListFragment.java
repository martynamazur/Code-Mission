package com.example.nauka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageListFragment extends Fragment {
    private RecyclerView recyclerView;

    public MessageListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_list, container, false);

        recyclerView = view.findViewById(R.id.message_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Message> listaWiadomosci = new ArrayList<>();
        listaWiadomosci.add(new Message("Nagłówek 1", "Treść wiadomości 1"));
        listaWiadomosci.add(new Message("Nagłówek 2", "Treść wiadomości 2"));
        listaWiadomosci.add(new Message("Nagłówek 3", "Treść wiadomości 3"));

        MessageAdapter adapter = new MessageAdapter(listaWiadomosci);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
