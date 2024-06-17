package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.AccountRecordDTO;
import com.maicon.todo_list_api.models.AccountModel;
import com.maicon.todo_list_api.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<AccountModel> createAccount(@RequestBody @Valid AccountRecordDTO accountRecordDTO) {
        return accountService.createAccount(accountRecordDTO);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Object> findAccount(@PathVariable(value = "id") Integer id) {
        return accountService.findAccount(id);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<Object> updateAccount(@PathVariable(value = "id") Integer id,
                                                @RequestBody @Valid AccountRecordDTO accountRecordDTO) {
        return accountService.updateAccount(id, accountRecordDTO);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<Object> deleteAccount(@PathVariable(value = "id") Integer id) {
        return accountService.deleteAccount(id);
    }
}
