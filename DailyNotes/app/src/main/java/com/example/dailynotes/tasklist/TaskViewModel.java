package com.example.dailynotes.tasklist;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.dailynotes.database.TaskDatabase;
import com.example.dailynotes.database.TaskModel;

import java.util.List;


public class TaskViewModel extends AndroidViewModel {

    private final LiveData<List<TaskModel>> taskList;
    private TaskDatabase taskDatabase;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        taskDatabase = TaskDatabase.getDatabase(this.getApplication());
        taskList = taskDatabase.taskModelDao().getAllTasks();
    }

    public LiveData<List<TaskModel>> getTaskList(){
        return taskList;
    }

    public void deleteTask(TaskModel taskModel){
        new deleteAsyncTask(taskDatabase).execute(taskModel);
    }

    private static class deleteAsyncTask extends AsyncTask<TaskModel,Void,Void> {

        private TaskDatabase taskDatabase;

        deleteAsyncTask(TaskDatabase taskDb) {
            taskDatabase = taskDb;
        }

        @Override
        protected Void doInBackground(TaskModel... taskModels) {
            taskDatabase.taskModelDao().deleteTask(taskModels[0]);
            return null;
        }
    }
}
