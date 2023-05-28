package com.example.nauka.TypeABCD;

import java.util.ArrayList;
import java.util.List;

public class QuestionModelFillBlock {

    private String title;
    private String questionDescription;
    private String correctAnwser;
    private String category;
    private List<String> codeText;
    private ArrayList<Integer> indeksEdit;

    public QuestionModelFillBlock(String title, String questionDescription, String correctAnwser, String category, List<String> codeText, ArrayList<Integer> indeksEdit) {
        this.title = title;
        this.questionDescription = questionDescription;
        this.correctAnwser = correctAnwser;
        this.category = category;
        this.codeText = codeText;
        this.indeksEdit = indeksEdit;
    }

    public String getTitle() {
        return title;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public String getCorrectAnwser() {
        return correctAnwser;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getCodeText() {
        return codeText;
    }

    public ArrayList<Integer> getIndeksEdit() {
        return indeksEdit;
    }
}
