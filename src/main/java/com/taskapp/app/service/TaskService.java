package com.taskapp.app.service;

import com.taskapp.app.model.Task;
import com.taskapp.app.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task save(String title,String text){
        Task task = new Task();
        task.setTaskText(text);
        task.setTitle(title);
        return taskRepository.save(task);
    }


    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    public Optional<Task> getTaskById(Long id){
        if(taskRepository.existsById(id)){
            return taskRepository.findById(id);
        }
        throw new NoSuchElementException("No task found");
    }



    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task addTask(Task task){
        try{
            return taskRepository.save(task);
        }catch (Exception e){
            throw new ArrayStoreException();
        }
    }

    public Task updateTask(Task task, long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return taskRepository.save(task);
        }
        throw new NoSuchElementException();
    }







}
