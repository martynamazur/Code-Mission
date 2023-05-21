package com.example.nauka.language;

public class LanguageModel {
    private String name;
    private boolean selected;
    private String flagIcon;

    public LanguageModel(String name, boolean selected, String flagIcon) {
        this.name = name;
        this.selected = selected;
        this.flagIcon = flagIcon;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getFlagIcon() {
        return flagIcon;
    }
}
