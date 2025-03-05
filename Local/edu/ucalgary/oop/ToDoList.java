package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    List<Task> tasks = new ArrayList<Task>();
    Stack<List<Task>> history = new Stack<List<Task>>();

    private void copyAndPush(){
        List<Task> copyList = new ArrayList<Task>();
        for (Task task : this.tasks) {
            copyList.add(task.copy());
        }
    this.history.push(copyList);
    }


    @Override
    public void addTask(Task task) {
        copyAndPush();
        this.tasks.add(task);
    }

    @Override
    public void deleteTask(String taskID) {
        copyAndPush();
        Task foundTask = null;

        for (Task task : this.tasks) {
            if (task.getId().equals(taskID)) {
                foundTask = task;
            }
        }

        if (foundTask != null) {
            this.tasks.remove(foundTask);
        }
    }

    @Override
    public void completeTask(String taskID) {
        copyAndPush();

        for (Task task : this.tasks) {
            if (task.getId().equals(taskID)) {
                task.setCompleted(true);
            }
        }
    }

    @Override
    public void editTask(String taskID, String taskName, Boolean completed) {
        copyAndPush();

        for (Task task : this.tasks) {
            if (task.getId().equals(taskID)) {
                task.setTitle(taskName);
                task.setId(taskID);
                task.setCompleted(completed);
            }
        }
    }

    @Override
    public void undo() {
        this.tasks = history.pop();
    }

    @Override
    public List<Task> listTasks() {
        return this.tasks;
    }
}
