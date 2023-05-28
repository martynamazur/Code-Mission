package com.example.nauka.changePassword;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.R;
import com.example.nauka.Zaloguj;
import com.example.nauka.singup.SingUp_DataValidation;

public class ChangePasswordNewPass extends AppCompatActivity {

    private TextView screenHeadline;
    private EditText newPasswordInput;
    private TextView tvLength;
    private TextView tvLetters;
    private TextView tvNumbers;
    private TextView tvSpecialSign;
    private Button buttonNavConfirm;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_change_password_page_step2);

        screenHeadline = findViewById(R.id.textView9);
        screenHeadline.setText("Ustaw nowe hasło");
        newPasswordInput = findViewById(R.id.editPassword);


        tvLength = findViewById(R.id.tvLength);
        tvLetters = findViewById(R.id.tvLetters);
        tvNumbers = findViewById(R.id.tvNumbers);
        tvSpecialSign = findViewById(R.id.tvSpecialSign);

        buttonNavConfirm = findViewById(R.id.buttonNavConfirm);

        newPasswordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {


                SingUp_DataValidation singUp_dataValidation = new SingUp_DataValidation(newPasswordInput.getText().toString());

                //zmiana tekstu podczas wpisywania
                if (singUp_dataValidation.isContainBigLetter() && singUp_dataValidation.isContainSmallLetter()) {
                    tvLetters.setTextColor(Color.GREEN);
                } else {
                    tvLetters.setTextColor(Color.RED);
                }

                if (singUp_dataValidation.isContainNumber()) {
                    tvNumbers.setTextColor(Color.GREEN);
                } else {
                    tvNumbers.setTextColor(Color.RED);
                }

                if (singUp_dataValidation.isContainSpecialSign()) {
                    tvSpecialSign.setTextColor(Color.GREEN);
                } else {
                    tvSpecialSign.setTextColor(Color.RED);
                }

                if (singUp_dataValidation.isRequiredLength()) {
                    tvLength.setTextColor(Color.GREEN);
                } else {
                    tvLength.setTextColor(Color.RED);
                }

            }
        });


        // implementacja kolorow spelniania kryteri
        //pamietac o tym aby byl podglad hasła po kliknieciu na ikonke
        // jak sie haslo zgadza to przechodzi, updatuje haslo w bazie danych

        buttonNavConfirm.setOnClickListener((v) ->{
            System.out.println("klikam");
            Intent intent = new Intent(ChangePasswordNewPass.this, Zaloguj.class);
            startActivity(intent);
        });
    }
}
