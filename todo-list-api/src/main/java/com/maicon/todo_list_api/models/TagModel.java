package com.maicon.todo_list_api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tag")
public class TagModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tag", nullable = false)
    private int idTag;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<TaskTagModel> tasks = new ArrayList<>();
}
