package com.wellness360.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Task {
    private UUID id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private TaskStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
