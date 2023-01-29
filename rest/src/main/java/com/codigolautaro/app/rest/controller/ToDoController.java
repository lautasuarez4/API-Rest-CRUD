package com.codigolautaro.app.rest.controller;

import com.codigolautaro.app.rest.Repository.ToDoRepository;
import com.codigolautaro.app.rest.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTask(){
        return toDoRepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String saveTask (@RequestBody Task task){
        toDoRepository.save(task);
        return "Task Saved";
        }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task request){

        Task updatedTask = toDoRepository.findById(id).get();
        updatedTask.setTitle(request.getTitle());
        updatedTask.setDescription(request.getDescription());
        toDoRepository.save(updatedTask);
        return "Task Updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task taskToDelete = toDoRepository.findById(id).get();
        toDoRepository.delete(taskToDelete);
        
        return "Task deleted";
    }



}
