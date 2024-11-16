package dev.rafaelj13.taskManager.Task;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taskmanager/api/")
public class TaskController {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskController(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    @GetMapping("")
    List<Task> findAll() {
        return taskRepository.findAll();
    }
    @GetMapping("{id}")
    Task findById(@PathVariable int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task not found"
            );
        }
        return task.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createTask(@Valid @RequestBody Task task) {
        taskRepository.create(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    void updateTask(@PathVariable int id, @Valid @RequestBody Task task) {
        taskRepository.update(task, id);
    }

    @DeleteMapping("")
    void deleteTask(@PathVariable int id) {
        taskRepository.delete(id);
    }
}
