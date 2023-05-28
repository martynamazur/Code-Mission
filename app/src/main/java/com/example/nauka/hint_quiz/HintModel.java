package com.example.nauka.hint_quiz;

import javax.xml.transform.sax.SAXResult;

public class HintModel {

    private String count;
    private String iconPath;
    public HintModel(String count, String iconPath) {
        this.count = count;
        this.iconPath = iconPath;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String  count) {
        this.count = count;

    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
