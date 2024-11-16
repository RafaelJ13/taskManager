package dev.rafaelj13.taskManager.Task;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record Task(
        Integer id,
        String name,
        LocalDateTime createdAt,
        @NotEmpty
        boolean completed
) {}
