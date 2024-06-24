package com.maicon.todo_list_api.config;

import com.maicon.todo_list_api.dtos.AccountRecordDTO;
import com.maicon.todo_list_api.dtos.LoginAccountRecordDTO;
import com.maicon.todo_list_api.models.AccountModel;
import com.maicon.todo_list_api.repositories.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AccountRepository accountRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;

    public void register(AccountRecordDTO accountRecordDTO) {
        AccountModel accountModel = new AccountModel();
        BeanUtils.copyProperties(accountRecordDTO, accountModel);
        accountModel.setPassword(passwordEncoder.encode(accountModel.getPassword()));
        accountRepository.save(accountModel);
    }

    public String login(LoginAccountRecordDTO loginRequest) {
        this.authenticate(loginRequest.email(), loginRequest.password());
        Optional<AccountModel> account = accountRepository.findByEmail(loginRequest.email());

        if (account.isEmpty()) {
            throw new EntityNotFoundException("Account not found");
        }

        return jwtService.generateToken(account.get());
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            System.out.println("erro aqui");
            System.out.println(e.getMessage());
        }
    }
}

