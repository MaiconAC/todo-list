package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.ListAccountRecordDTO;
import com.maicon.todo_list_api.models.ListAccountModel;
import com.maicon.todo_list_api.repositories.ListAccountRepository;
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

    public ResponseEntity<ListAccountModel> createListAccount(ListAccountRecordDTO listAccountRecordDTO) {
        var listAccountModel = new ListAccountModel();
        BeanUtils.copyProperties(listAccountRecordDTO, listAccountModel);

        return ResponseEntity.status(HttpStatus.OK).body(listAccountRepository.save(listAccountModel));
    }

    public ResponseEntity<List<ListAccountModel>> listListAccounts() {
        return ResponseEntity.status(HttpStatus.OK).body(listAccountRepository.findAll());
    }

    public ResponseEntity<Object> findListAccount(int id) {
        Optional<ListAccountModel> listAccount = listAccountRepository.findById(id);

        if (listAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List account not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(listAccount.get());
    }

    public ResponseEntity<Object> updateListAccount(int id, ListAccountRecordDTO listAccountRecordDTO) {
        Optional<ListAccountModel> listAccount = listAccountRepository.findById(id);

        if (listAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List account not found");
        }

        var listAccountModel = new ListAccountModel();
        BeanUtils.copyProperties(listAccountRecordDTO, listAccountModel);

        return ResponseEntity.status(HttpStatus.OK).body(listAccountRepository.save(listAccountModel));
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
