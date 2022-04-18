package com.example.photoearthobserver.model;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EpicApi {
    public static final String baseUrl = "https://epic.gsfc.nasa.gov/";
    public static final String baseImageUrl = "https://epic.gsfc.nasa.gov/archive/enhanced/";
    public static EpicApiService getEpicApiService() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        EpicApiService epicApiService = retrofit.create(EpicApiService.class);
        return epicApiService;
    }
}
