package bgergo.applications.taskmanager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(@PathVariable("taskId") Long id, @RequestParam(required = false) String name) {
        taskService.updateTask(id, name);
    }

}
