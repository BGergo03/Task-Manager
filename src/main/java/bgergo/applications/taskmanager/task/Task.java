package bgergo.applications.taskmanager.task;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private Boolean done;

    public Task() {
    }

    public Task(Long id, String name, String description, LocalDate creationDate, Boolean done) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.done = done;
    }

    public Task(String name, String description, LocalDate creationDate, Boolean done) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", done=" + done +
                '}';
    }
}
