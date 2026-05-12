package com.wellness360.service;

import com.wellness360.exception.TaskNotFoundException;
import com.wellness360.model.Task;
import com.wellness360.model.TaskStatus;
import com.wellness360.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskManagerService {
    private final TaskRepository taskRepository;
    public Task createTask(Task task) {
        task.setId(UUID.randomUUID());
        task.setStatus(TaskStatus.PENDING);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException(
                                "Task not found with id: " + id
                        ));
    }

    public Task updateTask(UUID id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(UUID id) {
        taskRepository.delete(id);
    }

    public Task markTaskComplete(UUID id) {

        Task task = getTaskById(id);

        task.setStatus(TaskStatus.COMPLETED);
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }


}
