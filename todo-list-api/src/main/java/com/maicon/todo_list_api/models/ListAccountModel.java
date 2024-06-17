package com.maicon.todo_list_api.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "list_account")
public class ListAccountModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_list_account", nullable = false)
    private int idListAccount;

    @Column(name = "id_list", nullable = false)
    private int idList;

    @Column(name = "id_account", nullable = false)
    private int idAccount;

    public int getIdListAccount() {
        return idListAccount;
    }

    public void setIdListAccount(int idListAccount) {
        this.idListAccount = idListAccount;
    }
}
