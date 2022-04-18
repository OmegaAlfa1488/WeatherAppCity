package com.example.dailynotes.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface TaskModelDao {

    @Query("SELECT * FROM TaskModel")
    LiveData<List<TaskModel>> getAllTasks();

    @Insert(onConflict = REPLACE)
    void insertTask(TaskModel taskModel);

    @Delete
    void deleteTask(TaskModel taskModel);
}
