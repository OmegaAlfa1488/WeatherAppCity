package com.example.dailynotes.tasklist;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailynotes.R;
import com.example.dailynotes.database.TaskModel;
import com.example.dailynotes.taskadd.TaskAddActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity  extends AppCompatActivity implements View.OnLongClickListener{

    private TaskViewModel taskViewModel;
    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        FloatingActionButton fabAddTask = findViewById(R.id.fab_add);

        fabAddTask.setOnClickListener(view -> {
            Intent addTaskIntent = new Intent(TaskActivity.this, TaskAddActivity.class);
            startActivity(addTaskIntent);
        });

        taskRecyclerView = findViewById(R.id.rv_list);
        taskAdapter = new TaskAdapter(new ArrayList<>(), this);
        layoutManager = new LinearLayoutManager(this);
        taskRecyclerView.setLayoutManager(layoutManager);

        // RecyclerView items divider
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(taskRecyclerView.getContext(),
                layoutManager.getOrientation());
        taskRecyclerView.addItemDecoration(dividerItemDecoration);

        taskRecyclerView.setAdapter(taskAdapter);

        // ViewModel
        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.getTaskList().observe(this, taskModels -> taskAdapter.addTask(taskModels));
    }

    @Override
    public boolean onLongClick(View view) {
        TaskModel taskModel = (TaskModel)view.getTag();
        taskViewModel.deleteTask(taskModel);
        Toast.makeText(this, taskModel.getTaskTitle()+" - Удалено!", Toast.LENGTH_SHORT).show();
        return true;
    }

}

