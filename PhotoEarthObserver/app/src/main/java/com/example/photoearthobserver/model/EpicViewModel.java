package com.example.photoearthobserver.model;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpicViewModel extends ViewModel {
    ListCallback listCallback;

    public EpicViewModel(ListCallback listCallback) {
        this.listCallback = listCallback;
    }

    public void getEpicModels(String date){
        EpicApi.getEpicApiService().requestEpicModel(date).enqueue(new Callback<List<EpicModel>>() {
            @Override
            public void onResponse(Call<List<EpicModel>> call, Response<List<EpicModel>> response) {
                listCallback.getEpicModesList(response.body());
            }

            @Override
            public void onFailure(Call<List<EpicModel>> call, Throwable t) {

            }
        });

    }
}
