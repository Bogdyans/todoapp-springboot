package org.bogdyan.todoapp.controllers;

import org.bogdyan.todoapp.models.ToDo;
import org.bogdyan.todoapp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<ToDo> getTodos() {
        return service.getAllTodos();
    }

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody ToDo todo) {
        String title = todo.getTitle();

        if (title == null || title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Title cannot be empty");
        }

        ToDo newTodo = service.createNewTodo(title);
        if (newTodo == null) {
            return ResponseEntity.badRequest().body("Failed to create todo.");
        }

        return new ResponseEntity<>("Todo created successfully", HttpStatus.CREATED);
    }

    @PatchMapping("/title/{id}")
    public ResponseEntity<String> updateTodoTitle(@RequestBody ToDo todo, @PathVariable Long id) {
        if (todo == null || id < 0) {
            return ResponseEntity.badRequest().body("Bad request");
        }

        ToDo updatedTodo = service.updateTodoTitle(id, todo.getTitle());
        if (updatedTodo == null) {
            return ResponseEntity.badRequest().body("Failed to update todo.");
        }

        return new ResponseEntity<>("Todo updated successfully", HttpStatus.OK);
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<String> updateTodoStatus(@RequestBody ToDo todo, @PathVariable Long id) {
        if (todo == null || id < 0) {
            return ResponseEntity.badRequest().body("Bad request");
        }

        ToDo updatedTodo = service.updateTodoStatus(id, todo.isCompleted());
        if (updatedTodo == null) {
            return ResponseEntity.badRequest().body("Failed to update todo.");
        }

        return new ResponseEntity<>("Todo updated successfully", HttpStatus.OK);
    }

}
