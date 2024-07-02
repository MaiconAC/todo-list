package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.ListAccountRecordDTO;
import com.maicon.todo_list_api.dtos.ListListIdsAndTitlesRecordDTO;
import com.maicon.todo_list_api.models.AccountModel;
import com.maicon.todo_list_api.models.ListAccountModel;
import com.maicon.todo_list_api.repositories.AccountRepository;
import com.maicon.todo_list_api.repositories.ListAccountRepository;
import com.maicon.todo_list_api.repositories.ListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListAccountService {
    @Autowired
    ListAccountRepository listAccountRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ListRepository listRepository;

    public ResponseEntity<Object> createListAccount(ListAccountRecordDTO listAccountRecordDTO) {
        boolean accountExists = accountRepository.existsById(listAccountRecordDTO.idAccount());

        if (!accountExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }

        boolean listExists = listRepository.existsById(listAccountRecordDTO.idList());

        if (!listExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        }

        var listAccountModel = new ListAccountModel();
        BeanUtils.copyProperties(listAccountRecordDTO, listAccountModel);

        return ResponseEntity.status(HttpStatus.OK).body(listAccountRepository.save(listAccountModel));
    }

    public ResponseEntity<Object> listListIdsAndTitles(int idAccount) {
        boolean accountExists = accountRepository.existsById(idAccount);

        if (!accountExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(listAccountRepository.listListIdsAndTitlesByAccountId(idAccount));
    }

    public ResponseEntity<Object> deleteListAccount(int id) {
        Optional<ListAccountModel> listAccount = listAccountRepository.findById(id);

        if (listAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List account not found");
        }

        listAccountRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("List account deleted successfully");
    }
}
