package com.wellness360.repository;

import com.wellness360.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Repository
public class TaskRepository {

    private TaskRepository takeRepository;
    private final Map<UUID, Task> store = new ConcurrentHashMap<>();
    public Task save(Task task) {
        store.put(task.getId(), task);
        return task;
    }

    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Task> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    public void delete(UUID id) {
        store.remove(id);
    }
}
