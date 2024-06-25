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
@Table(name = "list")
public class ListModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list", nullable = false)
    private int idList;

    @Column(name = "list_title", nullable = false)
    private String listTitle;

    @Column(name = "id_admin", nullable = false)
    private int idAdmin;

    @OneToMany(mappedBy = "list", fetch = FetchType.EAGER)
    private List<ListAccountModel> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "list", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<SectionModel> sections = new ArrayList<>();

    @OneToMany(mappedBy = "list", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<TaskModel> tasks = new ArrayList<>();
}
