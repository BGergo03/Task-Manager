package bgergo.applications.taskmanager.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public List<Task> getTasks() {
        return List.of(new Task(1L, "Task 1", "Description 1", null, false),
                new Task(2L, "Task 2", "Description 2", null, false));
    }

}
