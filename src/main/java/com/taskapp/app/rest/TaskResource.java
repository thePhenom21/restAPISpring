package com.taskapp.app.rest;


import com.taskapp.app.model.Task;
import com.taskapp.app.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class TaskResource {
    private TaskService taskService;

    public TaskResource(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping("tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("task-id/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") String id){
        Optional<Task> task = taskService.getTaskById(Long.parseLong(id));
        if(task.isPresent()){
            return ResponseEntity.of(task);
        }throw new NoSuchElementException();
    }



    @PostMapping("newTask/{title}/{text}") //body
    public ResponseEntity<Task> createTask(@PathVariable("title") String title,@PathVariable("text") String taskText){
        return ResponseEntity.ok(taskService.save(title,taskText));
    }

   // @PostMapping("updateTask/{id}") //

    @PostMapping("deleteTask/{id}")
    public void deleteTask(@PathVariable("id") String id){
        taskService.delete(Long.parseLong(id));
    }


}
