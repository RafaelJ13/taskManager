package dev.rafaelj13.taskManager.Task;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

     List<Task> findAll() {return tasks;}

    Optional<Task> findById(int id) {
        return tasks.stream()
                .filter(task -> task.id() == id)
                .findFirst();
    }

    void create(Task task) {
         tasks.add(task);
    }

    void update(Task task,Integer id) {
         Optional<Task> existingTask = findById(id);
         existingTask.ifPresent(value -> tasks.set(tasks.indexOf(value), task));

    }

    void delete(Integer id) {
         tasks.removeIf(task -> task.id().equals(id));
    }

    @PostConstruct
    private void init() {
        tasks.add(new Task(1,
                        "Complete REST API",
                        LocalDateTime.now(),
                        true

                )
        );
    }


}
