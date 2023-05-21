package com.example.nauka.TypeABCD;

import java.util.ArrayList;

//ABCD
public class QuestionModel {

    private String title;
    private String questionDescription;
    private String correctAnwser;
    private ArrayList<String> anwsers;

    public QuestionModel(String title, String questionDescription, String correctAnwser, ArrayList<String> anwsers) {
        this.title = title;
        this.questionDescription = questionDescription;
        this.correctAnwser = correctAnwser;
        this.anwsers = anwsers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getCorrectAnwser() {
        return correctAnwser;
    }

    public void setCorrectAnwser(String correctAnwser) {
        this.correctAnwser = correctAnwser;
    }

    public ArrayList<String> getAnwsers() {
        return anwsers;
    }

    public void setAnwsers(ArrayList<String> anwsers) {
        this.anwsers = anwsers;
    }



}
