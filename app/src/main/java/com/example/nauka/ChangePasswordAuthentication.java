package com.example.nauka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePasswordAuthentication extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepasswordauthentication);
        Button btnSendAgainMessage = findViewById(R.id.btnAgainSend);
        btnSendAgainMessage.setText("Send again");
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setText("Next");
        TextView txtBlock = findViewById(R.id.blockText2);
        txtBlock.setText("We send the code to your email.");
        EditText editCode = findViewById(R.id.editCode);
        editCode.setHint("Write code here");

    }
    public void setNewPass(View view){
        Intent intent = new Intent(this,ChangePasswordNewPass.class);
        startActivity(intent);

    }

}
