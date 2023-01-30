package com.codigolautaro.app.rest.repositories;

import com.codigolautaro.app.rest.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {

}
