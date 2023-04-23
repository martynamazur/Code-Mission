package com.example.nauka;

import java.util.Date;

public class Message {
    private String author;
    private String content;
    private String title;
    private Date date;

    public Message(String author, String content) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }
}
