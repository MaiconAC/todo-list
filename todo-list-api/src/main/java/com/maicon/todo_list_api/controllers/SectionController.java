package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.SectionRecordDTO;
import com.maicon.todo_list_api.services.SectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag(name = "Controller de Section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping("/sections")
    @Operation(summary = "Cria uma seção dentro da lista")
    public ResponseEntity<Object> createSection(@RequestBody @Valid SectionRecordDTO sectionRecordDTO) {
        return sectionService.createSection(sectionRecordDTO);
    }

    @PutMapping("/sections/{id}")
    @Operation(summary = "Atualiza a seção")
    public ResponseEntity<Object> updateSection(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid SectionRecordDTO sectionRecordDTO) {
        return sectionService.updateSection(id, sectionRecordDTO);
    }

    @DeleteMapping("/sections/{id}")
    @Operation(summary = "Deleta a seção")
    public ResponseEntity<Object> deleteSection(@PathVariable(name = "id") int id) {
        return sectionService.deleteSection(id);
    }
}
