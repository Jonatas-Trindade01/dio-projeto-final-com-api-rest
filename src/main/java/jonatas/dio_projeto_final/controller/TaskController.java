package jonatas.dio_projeto_final.controller;

import jonatas.dio_projeto_final.model.Task;
import jonatas.dio_projeto_final.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable int id) {
        var task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        var taskCreate = taskService.create(task);
        return ResponseEntity.ok(taskCreate);
    }

}
