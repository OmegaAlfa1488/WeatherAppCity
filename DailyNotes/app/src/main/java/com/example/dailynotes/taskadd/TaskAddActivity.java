package com.example.dailynotes.taskadd;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailynotes.R;
import com.example.dailynotes.database.TaskModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TaskAddActivity extends AppCompatActivity {
    private EditText inputTaskTitle;
    private EditText inputTaskDescription;
    private TaskAddViewModel taskAddViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_add);
        inputTaskTitle = findViewById(R.id.task_title);
        inputTaskDescription = findViewById(R.id.task_desc);
        taskAddViewModel = new ViewModelProvider(this).get(TaskAddViewModel.class);
        FloatingActionButton fabDoneTask = findViewById(R.id.fab_done);
        fabDoneTask.setOnClickListener(view -> {
            String taskTitle = inputTaskTitle.getText().toString();
            String taskDescription = inputTaskDescription.getText().toString();

            if(taskTitle.isEmpty() || taskDescription.isEmpty()){
                Toast.makeText(TaskAddActivity.this, R.string.input_error, Toast.LENGTH_SHORT).show();
            }else{
                taskAddViewModel.addTask(new TaskModel(inputTaskTitle.getText().toString(),
                        inputTaskDescription.getText().toString()
                ));
                finish();
            }
        });
    }
}
