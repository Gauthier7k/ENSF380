package edu.ucalgary.oop;

import java.util.List;

public interface IToDoList {
    void addTask(Task task);
    void deleteTask(String taskID);
    void completeTask(String taskID);
    void editTask(String taskID, String taskName, Boolean completed);
    void undo();
    List<Task> listTasks();
}