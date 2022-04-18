package com.example.photoearthobserver.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class EpicViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    private final ListCallback listCallback;

    public EpicViewModelFactory(ListCallback listCallback) {
        super();
        this.listCallback = listCallback;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == EpicViewModel.class) {
            return (T) new EpicViewModel(listCallback);
        }
        return null;
    }
}
