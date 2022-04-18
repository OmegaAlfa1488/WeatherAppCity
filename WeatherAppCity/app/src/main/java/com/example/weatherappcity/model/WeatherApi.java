package com.example.weatherappcity.model;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApi {
public static final String baseUrl = "https://api.openweathermap.org/";
   public static WeatherApiService getWeatherApiService() {
       HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
       logging.level(HttpLoggingInterceptor.Level.BODY);
       OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        WeatherApiService weatherApiService = retrofit.create(WeatherApiService.class);
            return weatherApiService;
   }
}

