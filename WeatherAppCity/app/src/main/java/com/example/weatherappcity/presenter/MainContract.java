package com.example.weatherappcity.presenter;

public interface MainContract {
    interface MainView{
    void showIcon(String icon);
    void setWeatherData(String temperature, String cityName, String mainWeather);
    }
    interface MainPresenter{
    void getWeather(String city);
    }
}
