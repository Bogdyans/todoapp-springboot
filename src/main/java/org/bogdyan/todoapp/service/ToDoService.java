package org.bogdyan.todoapp.service;

import org.bogdyan.todoapp.models.ToDo;
import org.bogdyan.todoapp.repository.ToDoRepository;
import org.springframework.stereotype.Service;



@Service
public class ToDoService {

    private final ToDoRepository repo;

    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public Iterable<ToDo> getAllTodos() {
        return repo.findAll();
    }

    public ToDo createNewTodo(String title) {
        ToDo toDo = new ToDo();
        toDo.setTitle(title);
        return repo.save(toDo);
    }

}
