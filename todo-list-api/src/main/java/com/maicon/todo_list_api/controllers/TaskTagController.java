package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TaskTagRecordDTO;
import com.maicon.todo_list_api.models.TaskTagModel;
import com.maicon.todo_list_api.services.TaskTagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "Controller de TaskTag")
public class TaskTagController {
    @Autowired
    TaskTagService taskTagService;

    @PostMapping("/taskTags")
    @Operation(summary = "Adiciona uma Tag a uma Task")
    public ResponseEntity<TaskTagModel> createTaskTag(@RequestBody @Valid TaskTagRecordDTO taskTagRecordDTO) {
        return taskTagService.createTaskTag(taskTagRecordDTO);
    }

    @GetMapping("/taskTags")
    @Operation(summary = "Lista todas as Tags de uma Task")
    public ResponseEntity<List<TaskTagModel>> listTaskTags() {
        return taskTagService.listTaskTags();
    }

    @DeleteMapping("/taskTags/{id}")
    @Operation(summary = "Remove uma Tag de uma Task")
    public ResponseEntity<Object> deleteTaskTag(@PathVariable(name = "id") int id) {
        return taskTagService.deleteTaskTag(id);
    }
}
