package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TagRecordDTO;
import com.maicon.todo_list_api.models.TagModel;
import com.maicon.todo_list_api.services.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "Controller de Tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    @Operation(summary = "Lista todas as Tags")
    public ResponseEntity<List<TagModel>> listTags() {
        return tagService.listTags();
    }

    @PutMapping("/tags/{id}")
    @Operation(summary = "Atualiza uma Tag")
    public ResponseEntity<Object> updateTag(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid TagRecordDTO tagRecordDTO) {
        return tagService.updateTag(id, tagRecordDTO);
    }

    @DeleteMapping("/tags/{id}")
    @Operation(summary = "Deleta uma Tag")
    public ResponseEntity<Object> deleteTag(@PathVariable(name = "id") int id) {
        return tagService.deleteTag(id);
    }
}
