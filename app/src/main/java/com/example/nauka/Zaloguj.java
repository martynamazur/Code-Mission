package com.example.nauka;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.nauka.bottomnavigation.MainActivityTransition;
import com.example.nauka.button.ButtonClickSound;
import com.example.nauka.resetPassword.ResetPassword;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;
import com.google.firebase.database.annotations.Nullable;

import java.util.Objects;


public class Zaloguj extends AppCompatActivity {



    private static final int REQ_ONE_TAP = 2;
    private boolean showOneTapUI = true;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;
    private DatabaseReference mDatabase;

    private Button btnZaloguj;
    private EditText editPassword;
    private EditText editEmail;
    private TextView messageisEmailExists;
    private TextView messageisPasswordRight;
    private ButtonClickSound buttonClickSound;
    private TextView continueFb;
    private Button continueGoogle;
    private Button twitter;



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaloguj);
        FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("co z tego444");

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.password);
        messageisEmailExists = findViewById(R.id.messageisEmailExists);
        messageisPasswordRight = findViewById(R.id.messageisPasswordRight);
        messageisPasswordRight.setVisibility(View.INVISIBLE);
        messageisEmailExists.setVisibility(View.INVISIBLE);
        btnZaloguj = findViewById(R.id.btnSignIn);
        continueGoogle = findViewById(R.id.continueGoogle);
        buttonClickSound = new ButtonClickSound(this);
        continueFb = findViewById(R.id.continueFb);
        //TextView contiuneGoogle = findViewById(R.id.continueGoogle);
        twitter = findViewById(R.id.continueTwitter);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        /*
        Logowanie przez google
        Utworzenie instancji klienta One Tap sign-in

        signInRequest jest obiektem BeginSignInRequest, który zawiera konfiguracjęn
        żądania logowania One Tap. Opcje żądania logowania są ustawiane za pomocą
        metod takich jak setPasswordRequestOptions(), setGoogleIdTokenRequestOptions()
        i setAutoSelectEnabled().

        Metoda setPasswordRequestOptions() konfiguruje opcje związane z żądaniem hasła,
         takie jak czy jest obsługiwane.
        Metoda setGoogleIdTokenRequestOptions() konfiguruje opcje związane z żądaniem
        tokena ID dla konta Google, takie jak czy jest obsługiwane, identyfikator klienta
        serwera i filtrowanie według autoryzowanych kont.
        Metoda setAutoSelectEnabled() ustawia automatyczne logowanie, jeśli spełnione
        są określone kryteria (np. użytkownik ma jedną zapisaną akredytację).
                 */
        oneTapClient = Identity.getSignInClient(this);
        signInRequest = BeginSignInRequest.builder()
                .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                        .setSupported(true)
                        .build())
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(getString(R.string.default_web_client_id))
                        .setFilterByAuthorizedAccounts(true)
                        .build())
                .setAutoSelectEnabled(true)
                .build();


        continueGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayOneTapSignInUI();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_ONE_TAP:
                try {
                    SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                    String idToken = credential.getGoogleIdToken();

                    /*

                    W przypadku uwierzytelniania za pomocą konta Google,
                    usernameId otrzymane z credential.getId() jest unikalnym
                     identyfikatorem dla danego konta Google. Możesz użyć tego
                     identyfikatora jako klucza dla identyfikacji użytkownika
                     w bazie danych lub w innych operacjach.

                     */

                    String usernameId = credential.getId();
                    String password = credential.getPassword();

                    if (idToken != null) {
                        Log.d(TAG, "Got ID token.");


                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


                        if (user != null) {
                            // Name, email address, and profile photo Url
                            String name = user.getDisplayName();
                            String email = user.getEmail();
                            System.out.println(email);
                            Uri photoUrl = user.getPhotoUrl();
                            writeNewUser(usernameId,email);

                        }


                        startNewActivity();


                    } else if (password != null) {
                        Log.d(TAG, "Got password.");
                    }
                } catch (ApiException e) {
                    switch (e.getStatusCode()) {
                        case CommonStatusCodes.CANCELED:
                            Log.d(TAG, "One-tap dialog was closed.");
                            showOneTapUI = false;
                            break;
                        case CommonStatusCodes.NETWORK_ERROR:
                            Log.d(TAG, "One-tap encountered a network error.");
                            break;
                        default:
                            Log.d(TAG, "Couldn't get credential from result." + e.getLocalizedMessage());
                            break;
                    }
                }
                break;
        }
    }

    private void displayOneTapSignInUI() {
        oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(this, result -> {
                    try {
                        startIntentSenderForResult(
                                result.getPendingIntent().getIntentSender(),
                                REQ_ONE_TAP,
                                null,
                                0,
                                0,
                                0
                        );
                    } catch (IntentSender.SendIntentException e) {
                        Log.d(TAG, e.getLocalizedMessage());
                    }
                })
                .addOnFailureListener(this, e -> Log.d(TAG, e.getLocalizedMessage()));
    }
    private void signOut() {
        oneTapClient.signOut();
    }


    public void showMessageErrorEmail(){
        messageisPasswordRight.setVisibility(messageisPasswordRight.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
    }
    public void showMessageErrorPassword(){
        messageisPasswordRight.setVisibility(messageisPasswordRight.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);

    }

    public void resetPassword(View view){

        Intent intent = new Intent(this, ResetPassword.class);
        startActivity(intent);

    }
    private void startNewActivity() {
        // Tutaj należy umieścić kod przejścia do nowej aktywności
        Intent intent = new Intent(this, MainActivityTransition.class);
        startActivity(intent);
    }
    public void writeNewUser(String userId, String email) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("messageWriteNewUser");
        myRef.setValue("co z 1");

        User user = new User(userId, email);

        mDatabase.child("users").child(userId).setValue(user);


    }

    /*
     private void saveUserToFirestore(String userEmail) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Users user = new Users(null,null, userEmail,null);
        db.collection("Users").add(user)
                .addOnSuccessListener(documentReference -> {
                    String userIdGen = documentReference.getId();
                    user.setUserId(userIdGen);

                    // Pobierz wygenerowany identyfikator dokumentu (unique_user_id)
                    // możesz go wykorzystać w dalszej pracy
                    // np. przypisanie go do obiektu User lub do innych operacji
                    // na tym konkretnym użytkowniku
                    // ...
                })
                .addOnFailureListener(e -> {
                    // Obsłuż ewentualny błąd
                    // ...
                });
    }


   */


}







