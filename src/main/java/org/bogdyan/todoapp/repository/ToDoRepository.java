package org.bogdyan.todoapp.repository;

import org.bogdyan.todoapp.models.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

}
