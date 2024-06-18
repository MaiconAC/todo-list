package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.TaskRecordDTO;
import com.maicon.todo_list_api.models.TaskModel;
import com.maicon.todo_list_api.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public ResponseEntity<TaskModel> createTask(TaskRecordDTO taskRecordDTO) {
        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskRecordDTO, taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.save(taskModel));
    }

    public ResponseEntity<List<TaskModel>> listTasks() {
        return ResponseEntity.status((HttpStatus.OK)).body(taskRepository.findAll());
    }

    public ResponseEntity<Object> findTask(Integer id) {
        Optional<TaskModel> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(task.get());
    }

    public ResponseEntity<Object> updateTask(Integer id, TaskRecordDTO taskRecordDTO) {
        Optional<TaskModel> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        var taskModel = task.get();
        BeanUtils.copyProperties(taskRecordDTO, taskModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskModel);
    }

    public ResponseEntity<Object> deleteTask(Integer id) {
        Optional<TaskModel> task = taskRepository.findById(id);

        if (task.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
        }

        taskRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }
}
