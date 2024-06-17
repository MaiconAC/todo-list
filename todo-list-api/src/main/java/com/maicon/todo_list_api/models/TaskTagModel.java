package com.maicon.todo_list_api.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "task_tag")
public class TaskTagModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_task_tag", nullable = false)
    private int idTaskTag;

    @Column(name = "id_task", nullable = false)
    private int idTask;

    @Column(name = "id_tag", nullable = false)
    private int idTag;

    public int getIdTaskTag() {
        return idTaskTag;
    }

    public void setIdTaskTag(int idTaskTag) {
        this.idTaskTag = idTaskTag;
    }
}
