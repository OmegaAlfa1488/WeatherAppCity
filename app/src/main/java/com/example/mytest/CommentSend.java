package com.example.mytest;

public class CommentSend {

    private String rate;
    private String text;
    private boolean success;

    public CommentSend(String rate, String text) {
        this.rate = rate;
        this.text = text;

    }

    public String getRate() {
        return rate;
    }

    public String getText() {
        return text;
    }

    public boolean isSuccess() {
        return success;
    }
}
