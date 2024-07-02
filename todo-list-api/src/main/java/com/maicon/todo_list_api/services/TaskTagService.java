package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.TaskTagRecordDTO;
import com.maicon.todo_list_api.models.TaskTagModel;
import com.maicon.todo_list_api.repositories.TaskTagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskTagService {
    @Autowired
    TaskTagRepository taskTagRepository;

    public ResponseEntity<TaskTagModel> createTaskTag(TaskTagRecordDTO taskTagRecordDTO) {
        var taskTagModel = new TaskTagModel();
        BeanUtils.copyProperties(taskTagRecordDTO, taskTagModel);

        return ResponseEntity.status(HttpStatus.OK).body(taskTagRepository.save(taskTagModel));
    }

    public ResponseEntity<List<TaskTagModel>> listTaskTags() {
        return ResponseEntity.status(HttpStatus.OK).body(taskTagRepository.findAll());
    }

    public ResponseEntity<Object> deleteTaskTag(int id) {
        Optional<TaskTagModel> taskTag = taskTagRepository.findById(id);

        if (taskTag.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task tag not found");
        }

        taskTagRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Task tag deleted successfully");
    }
}
