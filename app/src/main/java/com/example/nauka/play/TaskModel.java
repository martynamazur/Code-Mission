package com.example.nauka.play;

import com.example.nauka.TypeABCD.QuestionModelAbcd;
import com.example.nauka.TypeABCD.QuestionModelFillBlock;

import java.util.List;

public class TaskModel {
    private String taskTitle;
    private String param1;
    String category;
    private List<QuestionModelAbcd> abcdQuestions;
    private List<QuestionModelFillBlock> fillBlockQuestions;

    public TaskModel(String taskTitle, List<QuestionModelAbcd> abcdQuestions, List<QuestionModelFillBlock> fillBlockQuestions) {
        this.taskTitle = taskTitle;
        this.abcdQuestions = abcdQuestions;
        this.fillBlockQuestions = fillBlockQuestions;

    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public List<QuestionModelAbcd> getAbcdQuestions() {
        return abcdQuestions;
    }

    public void setAbcdQuestions(List<QuestionModelAbcd> abcdQuestions) {
        this.abcdQuestions = abcdQuestions;
    }

    public List<QuestionModelFillBlock> getFillBlockQuestions() {
        return fillBlockQuestions;
    }

    public void setFillBlockQuestions(List<QuestionModelFillBlock> fillBlockQuestions) {
        this.fillBlockQuestions = fillBlockQuestions;
    }

    public String getParam1() {
        return param1;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Dodaj gettery i settery dla pozostałych list pytań dla innych kategorii...

    // ... reszta kodu ...
}
