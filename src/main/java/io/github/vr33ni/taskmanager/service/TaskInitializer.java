package io.github.vr33ni.taskmanager.service;

import io.github.vr33ni.taskmanager.model.Task;
import io.github.vr33ni.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskInitializer {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskInitializer(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @jakarta.annotation.PostConstruct
    public void initializeTasks() {
        // Create and save a specific task
        Task task = new Task();
        task.setTitle("Example Task");
        task.setDescription("This is an example task created during application initialization.");
        taskRepository.save(task);
    }
}
