package com.maicon.todo_list_api.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "list")
public class ListModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_list", nullable = false)
    private int idList;

    @Column(name = "list_title", nullable = false)
    private String listTitle;

    @Column(name = "id_admin", nullable = false)
    private int idAdmin;

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }
}
