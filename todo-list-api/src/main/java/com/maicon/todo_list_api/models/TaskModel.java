package com.maicon.todo_list_api.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class TaskModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_task", nullable = false)
    private int idTask;

    @Column(name = "id_list", nullable = false)
    private int idList;

    @Column(name = "id_section", nullable = true)
    private int idSection;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "due_date", nullable = true)
    private LocalDateTime dueDate;

    @Column(name = "done", nullable = true)
    private boolean done;

    @Column(name = "finished_date", nullable = true)
    private LocalDateTime finishedDate;

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }
}
