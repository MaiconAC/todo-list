package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.ListRecordDTO;
import com.maicon.todo_list_api.models.ListModel;
import com.maicon.todo_list_api.services.ListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controller de List")
public class ListController {
    @Autowired
    ListService listService;

    @PostMapping("/lists")
    @Operation(summary = "Cria uma lista")
    public ResponseEntity<ListModel> createList(@RequestBody @Valid ListRecordDTO listRecordDTO) {
        return listService.createList(listRecordDTO);
    }

    @GetMapping("/lists/{id}")
    @Operation(summary = "Busca os dados da lista")
    public ResponseEntity<Object> findList(@PathVariable(value = "id") int id) {
        return listService.findList(id);
    }

    @PutMapping("/lists/{id}")
    @Operation(summary = "Atualiza a lista")
    public ResponseEntity<Object> updateList(@PathVariable(value = "id") int id,
                                             @RequestBody @Valid ListRecordDTO listRecordDTO) {
        return listService.updateList(id, listRecordDTO);
    }

    @DeleteMapping("/lists/{id}")
    @Operation(summary = "Deleta a lista")
    public ResponseEntity<Object> deleteList(@PathVariable(value = "id") int id) {
        return listService.deleteList(id);
    }
}
