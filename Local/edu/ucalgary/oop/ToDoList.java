package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    List<Task> tasks = new ArrayList<Task>();
    Stack<List<Task>> history = new Stack<List<Task>>();

    @Override
    public void addTask(Task task) {
        this.history.push(this.tasks);
        this.tasks.add(task);
    }

    @Override
    public void deleteTask(String taskID) {
        this.history.push(this.tasks);

        for (Task task : this.tasks) {
            if (task.getId().equals(taskID)) {
                this.tasks.remove(task);
            }
        }
    }

    @Override
    public void completeTask(String taskID) {
        this.history.push(this.tasks);

        for (Task task : this.tasks) {
            if (task.getId().equals(taskID)) {
                task.setCompleted(true);
            }
        }
    }

    @Override
    public void editTask(String taskID, String taskName, Boolean completed) {
        this.history.push(this.tasks);

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
