package com.example.mytest;

public class LoginResponse {

    public String getToken() {
        return token;
    }

    public boolean isSuccess() {
        return success;
    }

    private String token;
    private boolean success;
    private String message;

    public String getMessage() {
        return message;
    }

    public LoginResponse(String token, boolean success) {
        this.token = token;
        this.success = success;
    }


}
