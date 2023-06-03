package com.example.nauka.singup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.AccountVerification;
import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;
import com.example.nauka.button.ButtonClickSound;

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

    Button signUpbtn;

    int validationPass;
    DataBaseHelper dataBaseHelper;
    SingUp_DataValidation singUp_dataValidation;
    private ButtonClickSound buttonClickSound;



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

        signUpbtn = findViewById(R.id.btnSignUpNext);
        errorEmail = findViewById(R.id.errorEmail);
        errorPrivacyPolicy = findViewById(R.id.errorPrivacyPolicy);

        buttonClickSound = new ButtonClickSound(this);


        //zaimplementowac metode ktora czy validacji danych zmieni widocznosc



        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                singUp_dataValidation = new SingUp_DataValidation(
                        editTextEmail.getText().toString(),
                        editTextPassword.getText().toString(),
                        editTextRepeatPassword.getText().toString(),
                        newsletterAgreement.isChecked(),
                        privatePolicyAgreement.isChecked()
                );

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




        signUpbtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             buttonClickSound.playButtonClickSound();

             // przed tym musi mi funckja zwrocic czy wszystko co chcialam jest zaznaczone
             //do implementacji


             SingUp_DataValidation singUp_dataValidation = new SingUp_DataValidation(
                     editTextEmail.getText().toString(),
                     editTextPassword.getText().toString(),
                     editTextRepeatPassword.getText().toString(),
                     newsletterAgreement.isChecked(),
                     privatePolicyAgreement.isChecked()
             );

             if (singUp_dataValidation.correctInformation()) {

                 SinUp_UserModel sinUp_userModel = new SinUp_UserModel(editTextEmail.getText().toString(), editTextPassword.getText().toString(), newsletterAgreement, privatePolicyAgreement);
                 dataBaseHelper = new DataBaseHelper(SignUp.this);


                 boolean b = dataBaseHelper.addOne(sinUp_userModel);

                 Toast.makeText(SignUp.this, "Success=" + b, Toast.LENGTH_SHORT).show();


                 Intent intent = new Intent(SignUp.this, AccountVerification.class);
                 startActivity(intent);
             }

         }

    });


        editTextPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sprawdź aktualny stan widoku
                if (editTextPassword.isSelected()) {
                    // Hasło jest widoczne, więc zmień na ukryte
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // Hasło jest ukryte, więc zmień na widoczne
                    editTextPassword.setTransformationMethod(SingleLineTransformationMethod.getInstance());
                }

                // Zmień stan widoku
                editTextPassword.setSelected(!editTextPassword.isSelected());
            }
        });







    }


}
