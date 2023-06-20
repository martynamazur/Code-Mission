package com.example.nauka.linkedAccounts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nauka.R;
import com.example.nauka.language.LanguageManager;

import java.util.ArrayList;

public class LinkedAccount extends AppCompatActivity {

    private RecyclerView googleRc;
    private RecyclerView facebookRc;
    private FacebookRcAdapter facebookRcAdapter;
    private GoogleRcAdapter googleRcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linked_acc_page);

        googleRc = findViewById(R.id.googleRc);
        facebookRc = findViewById(R.id.fbRecycler);


        LinearLayoutManager layoutManagerGoogle = new LinearLayoutManager(LinkedAccount.this);
        LinearLayoutManager layoutManagerFacebook = new LinearLayoutManager(LinkedAccount.this);
        //Ustawienie Layout do rc
        googleRc.setLayoutManager(layoutManagerGoogle);
        facebookRc.setLayoutManager(layoutManagerFacebook);

        // Dla konta Google
        AccountInformationModel accountInformationModelGoogle = new AccountInformationModel("test1@gmail.com");
        ArrayList<AccountInformationModel> googleList = new ArrayList<>();
        googleList.add(accountInformationModelGoogle);

        googleRcAdapter = new GoogleRcAdapter(LinkedAccount.this, googleList);
        googleRc.setAdapter(googleRcAdapter);

        // Dla konta Facebook
        AccountInformationModel accountInformationModelFacebook = new AccountInformationModel("test2@gmail.com");
        ArrayList<AccountInformationModel> facebookList = new ArrayList<>();
        facebookList.add(accountInformationModelFacebook);
        facebookRcAdapter = new FacebookRcAdapter(LinkedAccount.this, facebookList);
        facebookRc.setAdapter(facebookRcAdapter);
    }
}
