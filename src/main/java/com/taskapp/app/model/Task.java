package com.taskapp.app.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Task {

    @GeneratedValue
    @Id
    private Long id;


    private String title;

    private String taskText;

    public Task(String title,String taskText){
        this.title = title;
        this.taskText = taskText;
    }

    public Task() {

    }


}
