package com.codigolautaro.app.rest.services;

import com.codigolautaro.app.rest.models.Task;
import com.codigolautaro.app.rest.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<Task> getAllTasks(){
        return toDoRepository.findAll();
    }

    public Task getTaskById(Long id){
        return toDoRepository.findById(id).get();
    }

    public void saveTask(Task task){
        toDoRepository.save(task);
    }

    public void saveTasks(List<Task> tasks){
        for (Task t : tasks){
            toDoRepository.save(t);
        }
    }

    public boolean updateTask (Long id, Task request){
        try{
            Task taskToUpdate = toDoRepository.findById(id).get();
            taskToUpdate.setTitle(request.getTitle());
            taskToUpdate.setDescription(request.getDescription());
            toDoRepository.save(taskToUpdate);
            return true;
        } catch (Exception e){
            return false;
        }

    }

    public boolean deleteTask(Long id){
        try{
        toDoRepository.deleteById(id);
        return true;
        }
        catch(Exception e){
        return false;
        }
    }


}
