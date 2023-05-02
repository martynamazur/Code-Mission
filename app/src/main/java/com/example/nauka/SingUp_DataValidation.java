package com.example.nauka;

import android.widget.CheckBox;

import java.util.Objects;

public class SingUp_DataValidation {

     String email_adress;
     String password;
     String reapeatPassword;
     boolean newsletter;
     boolean privacyPolicy;

    public SingUp_DataValidation(String email_adress, String password, String reapeatPassword, Boolean newsletter, Boolean privacyPolicy) {
        this.email_adress = email_adress;
        this.password = password;
        this.reapeatPassword = reapeatPassword;
        this.newsletter = newsletter;
        this.privacyPolicy = privacyPolicy;
    }

    public SingUp_DataValidation(String email_adress, String password) {
        this.email_adress = email_adress;
        this.password = password;
    }

    public boolean isPrivacyPolicyChecked(){
        return privacyPolicy;
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
}
    public  boolean isContainSmallLetter(){

        for (char c : password.toCharArray()){
            if (Character.isLowerCase(c)){
                return true;
            }
        }
        return false;


}

    public  boolean isContainNumber(){

        for (char c : password.toCharArray()){
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;


    }
    public boolean isContainSpecialSign() {
        String specialChars = "@#%^&+=!";
        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isRequiredLength(){
        return password.length() >= 8;
    }

    // ten koncowy po kliknieciu
    public boolean passwordValidation(String password) {
        String pattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#%^&+=!])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }


    public boolean correctInformation(){
        boolean isContainBigLetter = isContainBigLetter();
        boolean isContainSmallLetter = isContainSmallLetter();
        boolean isContainNumber = isContainNumber();
        boolean isContainSpecialSign = isContainSpecialSign();
        boolean isRequiredLength = isRequiredLength();
        boolean isPrivacyPolicy = isPrivacyPolicyChecked();

        //dopisac aby wysiwetlaly sie odpowiednie komunikaty jesli cos nie zostanie spelnione

        return isContainBigLetter && isContainSmallLetter && isContainNumber && isContainSpecialSign && isRequiredLength && isPrivacyPolicy;
    }


}


