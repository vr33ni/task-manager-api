// src/main/java/io/github/vr33ni/taskmanager/repository/TaskRepository.java
package io.github.vr33ni.taskmanager.repository;

import io.github.vr33ni.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
