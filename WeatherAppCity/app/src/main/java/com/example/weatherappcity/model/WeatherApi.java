package com.example.weatherappcity.model;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApi {
public static final String baseUrl = "http://api.openweathermap.org/";
   public static WeatherApiService getWeatherApiService() {
       HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
       interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        WeatherApiService weatherApiService = retrofit.create(WeatherApiService.class);
            return weatherApiService;
   }
}

