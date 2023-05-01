package com.example.nauka;

import android.widget.CheckBox;

import java.util.Objects;

public class SingUp_DataValidation {

    private String email_adress;
    private String password;
    private String reapeatPassword;
   private CheckBox newsletter;
    private CheckBox privacyPolicy;

    public SingUp_DataValidation(String email_adress, String password, String reapeatPassword, CheckBox newsletter, CheckBox privacyPolicy) {
        this.email_adress = email_adress;
        this.password = password;
        this.reapeatPassword = reapeatPassword;
        this.newsletter = newsletter;
        this.privacyPolicy = privacyPolicy;
    }

    public boolean isPrivacyPolicyChecked(){
        return privacyPolicy.isChecked();
    }

    public boolean isPasswordTheSame(){
        return Objects.equals(password, reapeatPassword);
    }

    public boolean passwordValidation(){

        return true;
    }

    // the function check if email adress is used already and associate with other account
    // check inside database
    public boolean ifAccountExists(){
        return true;

    }

    public  boolean isContainBigLetter(){

        for (char c : password.toCharArray()){
            if (Character.isUpperCase(c)){
                return true;
            }
    }
        return false;
}}


