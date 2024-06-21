package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.ListAccountRecordDTO;
import com.maicon.todo_list_api.models.ListAccountModel;
import com.maicon.todo_list_api.services.ListAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ListAccountController {
    @Autowired
    ListAccountService listAccountService;

    @PostMapping("/listAccounts")
    public ResponseEntity<ListAccountModel> createListAccount(@RequestBody @Valid ListAccountRecordDTO listAccountRecordDTO) {
        return listAccountService.createListAccount(listAccountRecordDTO);
    }

    @GetMapping("/listAccounts")
    public ResponseEntity<List<ListAccountModel>> listListAccounts() {
        return listAccountService.listListAccounts();
    }

    @GetMapping("/listAccounts/{id}")
    public ResponseEntity<Object> findListAccount(@PathVariable(name = "id") int id) {
        return listAccountService.findListAccount(id);
    }

    @PutMapping("/listAccounts/{id}")
    public ResponseEntity<Object> updateListAccount(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid ListAccountRecordDTO listAccountRecordDTO) {
        return listAccountService.updateListAccount(id, listAccountRecordDTO);
    }

    @DeleteMapping("/listAccounts/{id}")
    public ResponseEntity<Object> deleteListAccount(@PathVariable(name = "id") int id) {
        return listAccountService.deleteListAccount(id);
    }
}
