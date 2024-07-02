package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.ListAccountRecordDTO;
import com.maicon.todo_list_api.services.ListAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag(name = "Controller de ListAccount")
public class ListAccountController {
    @Autowired
    ListAccountService listAccountService;

    @PostMapping("/listAccounts")
    @Operation(summary = "Adiciona um usuário a uma lista")
    public ResponseEntity<Object> createListAccount(@RequestBody @Valid ListAccountRecordDTO listAccountRecordDTO) {
        return listAccountService.createListAccount(listAccountRecordDTO);
    }

    @GetMapping("/listAccounts/{id}")
    @Operation(summary = "Lista os ids e títulos de todas as listas do usuario")
    public ResponseEntity<Object> listListIdsAndTitles(@PathVariable(name = "id") int idAccount) {
        return listAccountService.listListIdsAndTitles(idAccount);
    }

    @DeleteMapping("/listAccounts/{id}")
    @Operation(summary = "Remove um usuário de uma lista")
    public ResponseEntity<Object> deleteListAccount(@PathVariable(name = "id") int id) {
        return listAccountService.deleteListAccount(id);
    }
}
