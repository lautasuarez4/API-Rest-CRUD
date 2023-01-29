package com.codigolautaro.app.rest.Repository;

import com.codigolautaro.app.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {

}
