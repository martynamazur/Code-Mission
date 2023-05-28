package com.example.nauka.changePassword;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;
import com.example.nauka.accountVerification.VerificationComplited;
import com.example.nauka.veryficationCode.CodeVerification;

public class ChangePasswordAuthentication extends AppCompatActivity {


    private TextView txtBlock;
    private TextView errorMessage;
    private Button btnConfirm;
    private Button btnSendAgainMessage;
    private ImageButton btnNavigPrevious;



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepasswordauthentication);

        btnSendAgainMessage = findViewById(R.id.btnAgainSend);
        btnConfirm = findViewById(R.id.btnNext);
        txtBlock = findViewById(R.id.blockText2);
        errorMessage = findViewById(R.id.errorMessage);
        btnNavigPrevious = findViewById(R.id.btnNavigPrevious);

        //Code
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);

        // Wywołanie metody dla poszczególnych pól tekstowych
        setFocusOnNextEditText(editText1, editText2);
        setFocusOnNextEditText(editText2, editText3);
        setFocusOnNextEditText(editText3, editText4);


    }

    private void setFocusOnNextEditText(final EditText currentEditText, final EditText nextEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    nextEditText.requestFocus();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }



    public void onClicknavPreviousScreen(View view){
        btnNavigPrevious.setOnClickListener(view1 -> {
            // do zaimplementowania
        });
    }

    public void onClickSendCodeAgain(View view){
        btnSendAgainMessage.setOnClickListener( v -> {
            System.out.println("Tu bedzie moduł odp za wysyłanie kodu weryfikacyjnych");
        });

    }

    public void onClickcConfirmBtn(View view){

        btnConfirm.setOnClickListener(v ->{

            //sprawdzenie czy kod weryfikacyjny się pokrywa
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefsReset", Context.MODE_PRIVATE);
            String email = sharedPreferences.getString("email","");
            CodeVerification codeVerification = new CodeVerification(email);

            if (codeVerification.verifyCode()){

                Intent intent = new Intent(this,ChangePasswordNewPass.class);
                startActivity(intent);

            }else {
                //kod sie nie pokrywa wyświetl komunikat
                errorMessage.setVisibility(View.VISIBLE);
            }
        });

    }


}
