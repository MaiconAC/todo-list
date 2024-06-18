package com.maicon.todo_list_api.controllers;

import com.maicon.todo_list_api.dtos.TaskRecordDTO;
import com.maicon.todo_list_api.models.TaskModel;
import com.maicon.todo_list_api.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<TaskModel> createTask(@RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        return taskService.createTask(taskRecordDTO);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskModel>> listTasks() {
        return taskService.listTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> findTask(@PathVariable(name = "id") Integer id) {
        return taskService.findTask(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable(name = "id") Integer id,
                                             @RequestBody @Valid TaskRecordDTO taskRecordDTO) {
        return taskService.updateTask(id, taskRecordDTO);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(name = "id") Integer id) {
        return taskService.deleteTask(id);
    }
}

