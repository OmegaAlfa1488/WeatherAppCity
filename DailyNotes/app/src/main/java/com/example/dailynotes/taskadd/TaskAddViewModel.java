package com.example.dailynotes.taskadd;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.dailynotes.database.TaskDatabase;
import com.example.dailynotes.database.TaskModel;

public class TaskAddViewModel extends AndroidViewModel {

    private TaskDatabase taskDatabase;

    public TaskAddViewModel(@NonNull Application application) {
        super(application);
        taskDatabase = TaskDatabase.getDatabase(this.getApplication());
    }

    public void addTask(final TaskModel taskModel){
        new addAsyncTask(taskDatabase).execute(taskModel);
    }

    private static class addAsyncTask extends AsyncTask<TaskModel, Void, Void> {

        private TaskDatabase db;

        addAsyncTask(TaskDatabase taskDatabase) {
            db = taskDatabase;
        }

        @Override
        protected Void doInBackground(final TaskModel... taskModels) {
            db.taskModelDao().insertTask(taskModels[0]);
            return null;
        }
    }
}

