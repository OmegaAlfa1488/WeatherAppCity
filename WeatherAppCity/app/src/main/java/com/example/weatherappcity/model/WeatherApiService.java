package com.example.weatherappcity.model;

import com.example.weatherappcity.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface WeatherApiService {

   @Headers("x-api-key: " + BuildConfig.API_KEY)
    @GET("data/2.5/weather")
    Call<WeatherModel> requestWeather(@Query("q") String city,@Query("units") String units);
}
