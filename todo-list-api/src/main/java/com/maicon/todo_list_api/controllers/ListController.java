package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.ListRecordDTO;
import com.maicon.todo_list_api.models.ListModel;
import com.maicon.todo_list_api.services.ListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {
    @Autowired
    ListService listService;

    @PostMapping("/lists")
    public ResponseEntity<ListModel> createList(@RequestBody @Valid ListRecordDTO listRecordDTO) {
        return listService.createList(listRecordDTO);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<ListModel>> listLists() {
        return listService.listLists();
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<Object> findList(@PathVariable(value = "id") Integer id) {
        return listService.findList(id);
    }

    @PutMapping("/lists/{id}")
    public ResponseEntity<Object> updateList(@PathVariable(value = "id") Integer id,
                                             @RequestBody @Valid ListRecordDTO listRecordDTO) {
        return listService.updateList(id, listRecordDTO);
    }

    @DeleteMapping("/lists/{id}")
    public ResponseEntity<Object> deleteList(@PathVariable(value = "id") Integer id) {
        return listService.deleteList(id);
    }
}
