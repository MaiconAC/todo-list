package com.maicon.todo_list_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "task")
public class TaskModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private int idTask;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_list", nullable = false)
    private ListModel list;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_section", nullable = true)
    private SectionModel section;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    private List<TaskTagModel> tags = new ArrayList<>();
}
