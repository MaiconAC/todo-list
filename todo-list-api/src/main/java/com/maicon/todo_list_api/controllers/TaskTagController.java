package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TaskTagRecordDTO;
import com.maicon.todo_list_api.models.TaskTagModel;
import com.maicon.todo_list_api.services.TaskTagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskTagController {
    @Autowired
    TaskTagService taskTagService;

    @PostMapping("/taskTags")
    public ResponseEntity<TaskTagModel> createTaskTag(@RequestBody @Valid TaskTagRecordDTO taskTagRecordDTO) {
        return taskTagService.createTaskTag(taskTagRecordDTO);
    }

    @GetMapping("/taskTags")
    public ResponseEntity<List<TaskTagModel>> listTaskTags() {
        return taskTagService.listTaskTags();
    }

    @GetMapping("/taskTags/{id}")
    public ResponseEntity<Object> findTaskTag(@PathVariable(name = "id") int id) {
        return taskTagService.findTaskTag(id);
    }

    @PutMapping("/taskTags/{id}")
    public ResponseEntity<Object> updateTaskTag(@PathVariable(name = "id") int id,
                                                @RequestBody @Valid TaskTagRecordDTO taskTagRecordDTO) {
        return taskTagService.updateTaskTag(id, taskTagRecordDTO);
    }

    @DeleteMapping("/taskTags/{id}")
    public ResponseEntity<Object> deleteTaskTag(@PathVariable(name = "id") int id) {
        return taskTagService.deleteTaskTag(id);
    }
}
