package com.maicon.todo_list_api.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
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

    @Column(name = "id_list", nullable = false)
    private int idList;

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }
}
