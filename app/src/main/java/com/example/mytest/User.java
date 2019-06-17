package com.example.mytest;

public class User {
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String password;
}
