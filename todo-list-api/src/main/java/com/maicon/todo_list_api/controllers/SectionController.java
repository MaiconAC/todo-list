package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.SectionRecordDTO;
import com.maicon.todo_list_api.models.SectionModel;
import com.maicon.todo_list_api.services.SectionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SectionController {
    @Autowired
    SectionService sectionService;

    @PostMapping("/sections")
    public ResponseEntity<SectionModel> createSection(@RequestBody @Valid SectionRecordDTO sectionRecordDTO) {
        return sectionService.createSection(sectionRecordDTO);
    }

    @GetMapping("/sections")
    public ResponseEntity<List<SectionModel>> listSections() {
        return sectionService.listSections();
    }

    @GetMapping("/sections/{id}")
    public ResponseEntity<Object> findSection(@PathVariable(name = "id") int id) {
        return sectionService.findSection(id);
    }

    @PutMapping("/sections/{id}")
    public ResponseEntity<Object> updateSection(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid SectionRecordDTO sectionRecordDTO) {
        return sectionService.updateSection(id, sectionRecordDTO);
    }

    @DeleteMapping("/sections/{id}")
    public ResponseEntity<Object> deleteSection(@PathVariable(name = "id") int id) {
        return sectionService.deleteSection(id);
    }
}
