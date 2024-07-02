package com.maicon.todo_list_api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "list_account")
public class ListAccountModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list_account", nullable = false)
    private int idListAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_list", nullable = false)
    private ListModel list;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account", nullable = false)
    private AccountModel account;
}
