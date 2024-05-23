package io.github.vr33ni.taskmanager.controller;

import io.github.vr33ni.taskmanager.model.Task;
import io.github.vr33ni.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        }).orElseGet(() -> {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
