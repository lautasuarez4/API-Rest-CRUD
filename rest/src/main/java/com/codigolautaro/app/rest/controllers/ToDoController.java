package com.codigolautaro.app.rest.controllers;

import com.codigolautaro.app.rest.repositories.ToDoRepository;
import com.codigolautaro.app.rest.models.Task;
import com.codigolautaro.app.rest.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class ToDoController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){

        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{id}")
    public Task getTaskById(@PathVariable Long id){

        return taskService.getTaskById(id);
    }

    @PostMapping(value = "/savetask")
    public String saveTask (@RequestBody Task requestTask){
        taskService.saveTask(requestTask);
        return "Task Saved";
        }

    @PostMapping(value = "/savetasks")
    public String saveTasks (@RequestBody List<Task> tasks){
        taskService.saveTasks(tasks);
        return "Tasks Saved";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task requestTask){

        if (taskService.updateTask(id, requestTask)) {
            return "Task Updated";
        }
        else return "Error";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id){

        if (taskService.deleteTask(id)){
            return "Task deleted";
        }
        else return "Error";

    }



}
