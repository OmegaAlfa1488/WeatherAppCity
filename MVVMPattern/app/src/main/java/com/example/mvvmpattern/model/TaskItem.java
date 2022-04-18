package com.example.mvvmpattern.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class TaskItem extends BaseObservable {
    public final ObservableField<Boolean> checked = new ObservableField<>();
    public final ObservableField<String> state = new ObservableField<>();
    public final ObservableField<String> event = new ObservableField<>();
}
