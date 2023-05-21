package com.example.nauka;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.homefeed.Message;
import com.example.nauka.homefeed.MessageAdapter;
import com.example.nauka.homefeed.MessageListFragment;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {


    private RecyclerView recyclerView;



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);



        //BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);




        // Tworzenie fragmentu i dodawanie go do layoutu
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MessageListFragment fragment = new MessageListFragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        recyclerView = findViewById(R.id.message_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        System.out.println("hejka 2");
        ArrayList<Message> listaWiadomosci = new ArrayList<>();
        listaWiadomosci.add(new Message("Nagłówek 1", "Treść wiadomości 1"));
        listaWiadomosci.add(new Message("Nagłówek 2", "Treść wiadomości 2"));
        listaWiadomosci.add(new Message("Nagłówek 3", "Treść wiadomości 3"));
        System.out.println("hejka 3");
        MessageAdapter adapter = new MessageAdapter(listaWiadomosci);
        System.out.println("hejka 4");
        recyclerView.setAdapter(adapter);




    }


}
