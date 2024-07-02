package com.maicon.todo_list_api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "task_tag")
public class TaskTagModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task_tag", nullable = false)
    private int idTaskTag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_task", nullable = false)
    private TaskModel task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tag", nullable = false)
    private TagModel tag;
}
