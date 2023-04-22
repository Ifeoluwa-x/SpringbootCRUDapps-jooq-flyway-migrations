package com.example.flyway.demo.controller;


import com.example.flyway.demo.service.UserService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public String addBook(@RequestBody Todo todo) {
        service.insertTodo(todo);
        return "book added...";
    }

    @GetMapping
    public List<Todo> getBooks() {
        return service.getTodo();
    }

    @DeleteMapping("/{id}")
    public String deleteTodoById(@PathVariable("id") int id) {
        service.deleteTodoById(id);
        return "Deleted...";
    }

    @PutMapping("/{id}")
    public String updateTodoById(@PathVariable("id") int id, @RequestBody Todo todo) {
        String newTaskName = todo.getTaskname();
        String newTaskDescription = todo.getTaskdescription();
        service.updateTodoById(id, newTaskName, newTaskDescription);
        return "Updated todo with id " + id;
    }
}