package com.example.nauka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

        TextView txtBlocktext = findViewById(R.id.textBlock);
        txtBlocktext.setText("Please reset you password here");
        EditText editEmailReset = findViewById(R.id.editEmailReset);
        editEmailReset.setHint("Email");
        Button btnResetuj = findViewById(R.id.btnResetuj);
        //Button btnSendAgainMessage = findViewById(R.id.btnSendAgain);
        btnResetuj.setText("Reset");
        //btnSendAgainMessage.setText("Send again");


    }
    public void onClickBtnReset(View view){
        try {
            Intent intent = new Intent(this,ChangePasswordAuthentication.class);
            startActivity(intent);
        }catch (Exception e){
            System.out.println("haha fuck it");
        }

    }
}
