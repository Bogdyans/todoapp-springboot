package org.bogdyan.todoapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @GetMapping
    public String getTodo() {
        return "Hello World";
    }

}
