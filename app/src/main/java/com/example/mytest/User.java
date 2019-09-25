package com.example.mytest;

public class User {
    private String username;
    private String password;
    public boolean success;
    public String token;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

}
