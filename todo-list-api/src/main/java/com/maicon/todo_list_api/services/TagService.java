package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.TagRecordDTO;
import com.maicon.todo_list_api.models.TagModel;
import com.maicon.todo_list_api.repositories.TagRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public ResponseEntity<List<TagModel>> listTags() {
        return ResponseEntity.status(HttpStatus.OK).body(tagRepository.findAll());
    }

    public ResponseEntity<Object> updateTag(int id, TagRecordDTO tagRecordDTO) {
        Optional<TagModel> tag = tagRepository.findById(id);

        if (tag.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tag not found");
        }

        var tagModel = new TagModel();
        BeanUtils.copyProperties(tagRecordDTO, tagModel);

        return ResponseEntity.status(HttpStatus.OK).body(tagRepository.save(tagModel));
    }

    public ResponseEntity<Object> deleteTag(int id) {
        Optional<TagModel> tag = tagRepository.findById(id);

        if (tag.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tag not found");
        }

        tagRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Tag deleted successfully");
    }
}
