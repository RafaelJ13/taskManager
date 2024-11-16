package dev.rafaelj13.taskManager.Task;


import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public record Task(
        Integer id,
        String name,
        LocalDateTime createdAt,
        boolean completed
) {
        public Task {
                if (id == null) {
                        id = 999;
                }
                createdAt = LocalDateTime.now();

        }

}
