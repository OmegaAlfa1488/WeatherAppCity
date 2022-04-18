package com.example.dailynotes.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = TaskModel.class, version = 1)
public abstract class TaskDatabase extends RoomDatabase {

    private static TaskDatabase INSTANCE;

    public static TaskDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class, "task_db")
                    .build();
        }
        return INSTANCE;
    }

    public abstract TaskModelDao taskModelDao();

}

