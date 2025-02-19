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

    public ToDo updateTodoTitle(Long id, String newTitle) {
        if (newTitle == null || newTitle.trim().isEmpty()) {
            return null;
        }

        ToDo toDo = repo.findById(id).orElse(null);
        if (toDo == null) {
            return null;
        }

        toDo.setTitle(newTitle);
        return repo.save(toDo);
    }

    public ToDo updateTodoStatus(Long id, boolean completed) {
        ToDo toDo = repo.findById(id).orElse(null);
        if (toDo == null) {
            return null;
        }

        System.out.println("ds");

        toDo.setCompleted(completed);
        return repo.save(toDo);
    }
}
