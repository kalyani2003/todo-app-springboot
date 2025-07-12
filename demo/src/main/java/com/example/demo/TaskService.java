package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task save(Task task) {
        return repo.save(task);
    }

    public Optional<Task> update(String id, Task task) {
        return repo.findById(id).map(t -> {
            t.setTitle(task.getTitle());
            t.setCompleted(task.isCompleted());
            return repo.save(t);
        });
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
