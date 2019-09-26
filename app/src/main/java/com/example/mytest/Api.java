package com.example.mytest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

     String BASE_URL = "http://smktesting.herokuapp.com/api/";

    @POST("register/")
    Call<User> createAccount(
            @Body User user);

    @POST("login/")
    Call<User> userLogin(
           // @Header("Authorization: Token ") String token,
            @Body User user);


}
