package com.example.nauka.walkrought;
public class Slide {
    private String title;
    private String description;
    private String image;
    private boolean isLastSlide;



    public Slide(String title, String description, String image,boolean isLastSlide) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.isLastSlide = isLastSlide;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
    public String getDescription() {
        return description;
    }
    public boolean isLastSlide() {
        return isLastSlide;
    }

}
