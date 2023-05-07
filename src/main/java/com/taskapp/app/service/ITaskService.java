package com.taskapp.app.service;

import com.taskapp.app.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    public Task save(String title, String text);


    public void delete(Long id);


    public Optional<Task> getTaskById(Long id);

    public List<Task> getAllTasks();

    public Task addTask(Task task);

    public Task updateTask(Task task, long id);
}
