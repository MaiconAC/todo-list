package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.ListRecordDTO;
import com.maicon.todo_list_api.models.ListModel;
import com.maicon.todo_list_api.repositories.ListRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListService {
    @Autowired
    ListRepository listRepository;

    public ResponseEntity<ListModel> createList(ListRecordDTO listRecordDTO) {
        var listModel = new ListModel();
        BeanUtils.copyProperties(listRecordDTO, listModel);

        return ResponseEntity.status(HttpStatus.OK).body(listRepository.save(listModel));
    }

    public ResponseEntity<Object> findList(int id) {
        Optional<ListModel> list = listRepository.findById(id);

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(list.get());
    }

    public ResponseEntity<Object> updateList(int id, ListRecordDTO listRecordDTO) {
        Optional<ListModel> list = listRepository.findById(id);

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        }

        var listModel = list.get();
        BeanUtils.copyProperties(listRecordDTO, listModel);

        return ResponseEntity.status(HttpStatus.OK).body(listRepository.save(listModel));
    }

    public ResponseEntity<Object> deleteList(int id) {
        boolean listExist = listRepository.existsById(id);

        if (!listExist) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        }

        listRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("List deleted successfully");
    }
}
