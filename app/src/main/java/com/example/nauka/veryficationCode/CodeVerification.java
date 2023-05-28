package com.example.nauka.veryficationCode;

import com.example.nauka.DataBaseHelper;

public class CodeVerification {

    private DataBaseHelper db;
    private String inputCode;

    public CodeVerification(String inputCode) {
        this.inputCode = inputCode;
    }

    public boolean verifyCode(){

        //wyciagniecie z bazy tymczasowego kodu
        String generatedCode = "";

        //porownanie czy sie zgadza
        return inputCode.equals(generatedCode);

    }
}
