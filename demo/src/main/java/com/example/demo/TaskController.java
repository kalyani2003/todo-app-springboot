package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping("/task")
    public Task create(@RequestBody Task task) {
        return service.save(task);
    }

    @PutMapping("/task/{id}")
    public Optional<Task> update(@PathVariable String id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/task/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

