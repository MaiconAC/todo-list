package com.maicon.todo_list_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "section")
public class SectionModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_section", nullable = false)
    private int idSection;

    @Column(name = "section_title", nullable = false)
    private String sectionTitle;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_list", nullable = false)
    private ListModel list;

    @OneToMany(mappedBy = "section", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<TaskModel> tasks = new ArrayList<>();
}
