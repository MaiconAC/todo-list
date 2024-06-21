package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TagRecordDTO;
import com.maicon.todo_list_api.models.TagModel;
import com.maicon.todo_list_api.services.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping("/tags")
    public ResponseEntity<TagModel> createTag(@RequestBody @Valid TagRecordDTO tagRecordDTO) {
        return tagService.createTag(tagRecordDTO);
    }

    @GetMapping("/tags")
    public ResponseEntity<List<TagModel>> listTags() {
        return tagService.listTags();
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<Object> findTag(@PathVariable(name = "id") int id) {
        return tagService.findTag(id);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<Object> updateTag(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid TagRecordDTO tagRecordDTO) {
        return tagService.updateTag(id, tagRecordDTO);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<Object> deleteTag(@PathVariable(name = "id") int id) {
        return tagService.deleteTag(id);
    }
}
