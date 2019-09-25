package com.example.mytest;

public class ListItems {
    private String id;
    private String title;
    private String img;
    private String text;

    public ListItems(String id, String img, String text, String title) {
        this.id = id;
        this.img = img;
        this.text = text;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

}
