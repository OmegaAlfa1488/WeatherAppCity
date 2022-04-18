package com.example.dailynotes.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaskModel {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    private String taskTitle;
    private String taskDesc;

    public TaskModel(String taskTitle, String taskDesc) {
        this.taskTitle = taskTitle;
        this.taskDesc = taskDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }
}
