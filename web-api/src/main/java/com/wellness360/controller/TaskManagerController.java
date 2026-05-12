package com.wellness360.controller;

import com.wellness360.model.Task;
import com.wellness360.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/task")
@RequiredArgsConstructor
@Slf4j
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskManagerService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskManagerService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskManagerService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable UUID id,
            @RequestBody Task task) {

        return taskManagerService.updateTask(id, task);
    }

    @PatchMapping("/{id}")
    public Task patchTask(
            @PathVariable UUID id) {

        return taskManagerService.markTaskComplete(id);
    }



}
