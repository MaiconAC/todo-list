package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.AccountRecordDTO;
import com.maicon.todo_list_api.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controller de Account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{id}")
    @Operation(summary = "Busca os dados da conta do usuário")
    public ResponseEntity<Object> findAccount(@PathVariable(value = "id") Integer id) {
        return accountService.findAccount(id);
    }

    @PutMapping("/accounts/{id}")
    @Operation(summary = "Atualiza os dados da conta do usuário")
    public ResponseEntity<Object> updateAccount(@PathVariable(value = "id") Integer id,
                                                @RequestBody @Valid AccountRecordDTO accountRecordDTO) {
        return accountService.updateAccount(id, accountRecordDTO);
    }

    @DeleteMapping("/accounts/{id}")
    @Operation(summary = "Deleta a conta do usuário")
    public ResponseEntity<Object> deleteAccount(@PathVariable(value = "id") Integer id) {
        return accountService.deleteAccount(id);
    }
}
