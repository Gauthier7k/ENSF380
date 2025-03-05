package edu.ucalgary.oop;

import java.util.*;

public interface IToDoList {
    void addTask(Task Task);
    void deleteTask(String Taskname);
    void completeTask(String Task);
    void editTask(String TaskName, String Description, Boolean Completed);
    void undo();
    List<Task> listTasks();
}