package com.example.mvvmpattern.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.databinding.TaskListBinding;
import com.example.mvvmpattern.model.TaskItem;

import java.util.ArrayList;
import java.util.List;

public class TaskViewModel extends Fragment {
    public List<TaskItem> taskItemList;
    public TaskAdapter taskAdapter;
    TaskListBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_list,container,false);
        binding = DataBindingUtil.setContentView(getActivity(),R.layout.task_list);
        taskItemList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskItemList, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(taskAdapter);
        binding.button.setOnClickListener(view1 -> onAddItem());
        return view;
    }

    private void onAddItem() {
    String input = binding.editText.getText().toString();
    if (TextUtils.isEmpty(input)){
        Toast.makeText(getActivity(),"Укажите задачу!",Toast.LENGTH_LONG).show();
        return;
    }
    TaskItem taskItem = new TaskItem();
    taskItem.event.set(input);
    taskItem.state.set("Отмена");
    taskItemList.add(taskItem);
    binding.editText.setText("");
    taskAdapter.notifyDataSetChanged();
    }
}
