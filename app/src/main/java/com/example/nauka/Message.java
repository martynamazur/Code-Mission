package com.example.nauka;

import java.util.Date;

public class Message {
    private String header;
    private String content;
    private Date date;
    private int messageId;

    public Message(String header, String content, Date date) {
        this.header = header;
        this.content = content;
        this.date = date;
    }

    public Message() {

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
