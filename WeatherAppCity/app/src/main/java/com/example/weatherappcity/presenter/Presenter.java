package com.example.weatherappcity.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.weatherappcity.model.WeatherApi;
import com.example.weatherappcity.model.WeatherApiService;
import com.example.weatherappcity.model.WeatherModel;
import com.example.weatherappcity.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements MainContract.MainPresenter{
    private MainContract.MainView view;
    WeatherApiService weatherApiService;
    Context context;
    public Presenter(Context context, MainContract.MainView view) {
        this.view = view;
        this.context = context;
    }
    @Override
    public void getWeather(String city) {
        weatherApiService = WeatherApi.getWeatherApiService();
        weatherApiService.requestWeather(city,"metric").enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()){
                    if (response.body()!=null){
                WeatherModel model = response.body();
                view.setWeatherData(Integer.toString((int)(model.getMain().getTemp())),model.getName(), model.getWeather().get(0).getMain());
                view.showIcon(model.getWeather().get(0).getMain());
                }
                }else Toast.makeText(context, "Wrong input city",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Toast.makeText(context, "Error occurred!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
