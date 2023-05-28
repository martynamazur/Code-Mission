package com.example.nauka.TypeABCD;

import java.util.ArrayList;
import java.util.List;

//ABCD
public class QuestionModelAbcd {

    private String title;
    private String questionDescription;
    private String correctAnwser;
    private List<String> anwsers;
    private String category;
    private int correctAnwserId;



    public QuestionModelAbcd(String title, String questionDescription, String correctAnwser, List<String> anwsers, int correctAnswerIndex) {
        this.title = title;
        this.questionDescription = questionDescription;
        this.correctAnwser = correctAnwser;
        this.anwsers = anwsers;
        this.correctAnwserId = correctAnswerIndex;
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

    public List<String> getAnwsers() {
        return anwsers;
    }

    public void setAnwsers(ArrayList<String> anwsers) {
        this.anwsers = anwsers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public int getCorrectAnwserId() {
        return correctAnwserId;
    }
}
