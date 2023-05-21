package com.example.nauka.singup;

import android.widget.CheckBox;

public class SinUp_UserModel {

    private String email_adress;
    private String password;

    private CheckBox newsletter;
    private CheckBox privacyPolicy;

    public SinUp_UserModel(String email_adress, String password, CheckBox newsletter, CheckBox privacyPolicy) {
        this.email_adress = email_adress;
        this.password = password;

        this.newsletter = newsletter;
        this.privacyPolicy = privacyPolicy;
    }

    @Override
    public String toString() {
        return "SinUp{" +
                "email_adress='" + email_adress + '\'' +
                ", password='" + password + '\'' +
                ", newsletter=" + newsletter +
                ", privacyPolicy=" + privacyPolicy +
                '}';
    }

    public String getEmail_adress() {
        return email_adress;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public CheckBox getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(CheckBox newsletter) {
        this.newsletter = newsletter;
    }

    public CheckBox getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(CheckBox privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }
}
