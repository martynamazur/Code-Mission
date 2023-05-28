package com.example.nauka.resetPassword;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.nauka.DataBaseHelper;
import com.example.nauka.R;
import com.example.nauka.changePassword.ChangePasswordAuthentication;

public class ResetPassword extends AppCompatActivity {

    private EditText dateInput;
    private TextView validation_mess;
    private TextView txtBlocktext;
    private Button btnResetuj;
    private DataBaseHelper dataBaseHelper;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);

        validation_mess = findViewById(R.id.validation_mess);
        txtBlocktext = findViewById(R.id.textBlock);
        dateInput = findViewById(R.id.editEmailReset);
        btnResetuj = findViewById(R.id.btnResetuj);
        validation_mess.setVisibility(View.INVISIBLE);


    }

    public void onClickBtnReset(View view) {

        //wyszukuje w bazie danych czy taki uzytkownik istnieje
        dataBaseHelper = new DataBaseHelper(ResetPassword.this);
        if (dataBaseHelper.isEmailExists(dateInput.getText().toString().trim())){
            btnResetuj.setOnClickListener(v->{

                savePreferences();
                // jesli isnieje przechodzi do nowej aktywnosci

                Intent intent = new Intent(ResetPassword.this, ChangePasswordAuthentication.class);
                startActivity(intent);

            });
        }else{
            //pokazuje komunikat
            validation_mess.setVisibility(View.VISIBLE);
        }

    }

    private void savePreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefsReset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", dateInput.getText().toString());
        editor.apply();

    }
}
