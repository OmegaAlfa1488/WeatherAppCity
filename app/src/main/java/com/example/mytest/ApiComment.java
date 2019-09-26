package com.example.mytest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;



public interface ApiComment {

    String URL_DATA_COMMENT = "http://smktesting.herokuapp.com/api/reviews/";

    @POST("1/")
    Call<CommentSend> sendComment(
           // @Header("Authorization: Token ") String token,
            @Body CommentSend commentSend);

}
