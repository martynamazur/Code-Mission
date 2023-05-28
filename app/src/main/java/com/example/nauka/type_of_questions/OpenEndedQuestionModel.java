package com.example.nauka.type_of_questions;

import java.util.List;

/*
Te w ktorych tzreba cos wpisac w okienku
 */
public class OpenEndedQuestionModel {
    private String questionText;
    private List<String> blankSpaces; // Lista miejsc do uzupełnienia

    // Konstruktor, gettery, settery, itp.

    // Metoda dodająca nowe miejsce do uzupełnienia
    public void addBlankSpace(String blankSpace) {
        blankSpaces.add(blankSpace);
    }

    // Metoda zwracająca ilość miejsc do uzupełnienia
    public int getBlankSpacesCount() {
        return blankSpaces.size();
    }

    // Metoda zwracająca identyfikator pola na podstawie indeksu
    public String getBlankSpaceId(int index) {
        // Tu możesz np. generować identyfikatory na podstawie indeksu
        // np. "blankSpace1", "blankSpace2", itd.
        // Możesz też korzystać z innych identyfikatorów, które są zdefiniowane w aplikacji.
        // Zależy to od Twojego konkretnego przypadku.
        return "blankSpace" + (index + 1);
    }
}
