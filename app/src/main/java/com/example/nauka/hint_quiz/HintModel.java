package com.example.nauka.hint_quiz;

import javax.xml.transform.sax.SAXResult;

public class HintModel {

    private int count;
    private String iconPath;
    public HintModel(int count, String iconPath) {
        this.count = count;
        this.iconPath = iconPath;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
