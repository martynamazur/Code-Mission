package com.example.nauka;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    // data validation hidden messages
    TextView errorEmail;
    TextView errorPrivacyPolicy;

    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextRepeatPassword;

    CheckBox privatePolicyAgreement;
    CheckBox newsletterAgreement;

    // password must include , textview

    TextView tvLength;
    TextView tvLetters;
    TextView tvNumbers;
    TextView tvSpecialSign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        newsletterAgreement = findViewById(R.id.newsletterAgreement);
        privatePolicyAgreement = findViewById(R.id.privatePolicyAgreement);
        editTextRepeatPassword = findViewById(R.id.editTextRepeatPassword);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        tvLength = findViewById(R.id.tvLength);
        tvLetters = findViewById(R.id.tvLetters);
        tvNumbers = findViewById(R.id.tvNumbers);
        tvSpecialSign = findViewById(R.id.tvSpecialSign);


        //zaimplementowac metode ktora czy validacji danych zmieni widocznosc
        errorEmail.setVisibility(View.INVISIBLE);
        errorPrivacyPolicy.setVisibility(View.INVISIBLE);


        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                SingUp_DataValidation singUp_dataValidation= new SingUp_DataValidation(editTextEmail,editTextPassword,newsletterAgreement,privatePolicyAgreement);
                if (singUp_dataValidation.passwordValidation()) {
                    //passwordValidationTextView.setText("Hasło spełnia wymagania");
                } else if (singUp_dataValidation.ifAccountExists()) {
                    //passwordValidationTextView.setText("Hasło nie spełnia wymagań");
                }else if (singUp_dataValidation.isPasswordTheSame()){


                }else if(singUp_dataValidation.isPrivacyPolicyChecked()){

                }
            }
        });
    }


}
