package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.AccountRecordDTO;
import com.maicon.todo_list_api.models.AccountModel;
import com.maicon.todo_list_api.repositories.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public ResponseEntity<AccountModel> createAccount(AccountRecordDTO accountRecordDTO) {
        var accountModel = new AccountModel();
        BeanUtils.copyProperties(accountRecordDTO, accountModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(accountModel));
    }

    public ResponseEntity<Object> findAccount(Integer id) {
        Optional<AccountModel> account = accountRepository.findById(id);

        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(account.get());
    }

    public ResponseEntity<Object> updateAccount(Integer id, AccountRecordDTO accountRecordDTO) {
        Optional<AccountModel> account = accountRepository.findById(id);

        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }

        var accountModel = account.get();
        BeanUtils.copyProperties(accountRecordDTO, accountModel);

        return ResponseEntity.status(HttpStatus.OK).body(accountRepository.save(accountModel));
    }

    public ResponseEntity<Object> deleteAccount(Integer id) {
        Optional<AccountModel> account = accountRepository.findById(id);

        if (account.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }

        accountRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Account deleted successfully");
    }

}
