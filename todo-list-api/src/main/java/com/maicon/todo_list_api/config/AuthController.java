package com.maicon.todo_list_api.config;

import com.maicon.todo_list_api.dtos.AccountRecordDTO;
import com.maicon.todo_list_api.dtos.LoginAccountRecordDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void register(@RequestBody AccountRecordDTO accountRecordDTO) {
        authService.register(accountRecordDTO);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginAccountRecordDTO loginAccountRecordDTO) {
        return ResponseEntity.ok(authService.login(loginAccountRecordDTO));
    }
}
