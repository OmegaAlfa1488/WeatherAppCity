package com.example.photoearthobserver.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EpicApiService {
    @GET("api/enhanced/date/{date}")
    Call<List<EpicModel>> requestEpicModel(@Path("date") String date);
}
