package bgergo.applications.taskmanager.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void addTask(Task task) {
        Optional<Task> taskOptional = taskRepository.findTaskByName(task.getName());
        if (taskOptional.isPresent()) {
            throw new IllegalStateException("Task already exists with the name: " + task.getName());
        }
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalStateException("Task with id " + id + " does not exist.");
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public void updateTask(Long id, String name) {
        Task taskToUpdate = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Task with id " + id + " does not exist."));

        if (name == null || name.isEmpty() || name.equals(taskToUpdate.getName())) {
            return;
        }

        if (taskRepository.findTaskByName(name).isPresent()) {
            throw new IllegalStateException("Task already exists with the name: " + name);
        }

        taskToUpdate.setName(name);
    }

}
