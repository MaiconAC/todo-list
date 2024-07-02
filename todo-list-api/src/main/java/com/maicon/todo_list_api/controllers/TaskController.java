package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TaskRecordDTO;
import com.maicon.todo_list_api.models.TaskModel;
import com.maicon.todo_list_api.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Controller de Task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    @Operation(summary = "Cria uma tarefa")
    public ResponseEntity<TaskModel> createTask(@RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        return taskService.createTask(taskRecordDTO);
    }

    @PutMapping("/tasks/{id}")
    @Operation(summary = "Atualiza a tarefa")
    public ResponseEntity<Object> updateTask(@PathVariable(name = "id") Integer id,
                                             @RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        return taskService.updateTask(id, taskRecordDTO);
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(summary = "Deleta a tarefa")
    public ResponseEntity<Object> deleteTask(@PathVariable(name = "id") Integer id) {
        return taskService.deleteTask(id);
    }
}

