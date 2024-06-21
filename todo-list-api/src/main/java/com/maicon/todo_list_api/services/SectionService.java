package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.SectionRecordDTO;
import com.maicon.todo_list_api.models.SectionModel;
import com.maicon.todo_list_api.repositories.SectionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;

    public ResponseEntity<SectionModel> createSection(SectionRecordDTO sectionRecordDTO) {
        var sectionModel = new SectionModel();
        BeanUtils.copyProperties(sectionRecordDTO, sectionModel);

        return ResponseEntity.status(HttpStatus.OK).body(sectionRepository.save(sectionModel));
    }

    public ResponseEntity<List<SectionModel>> listSections() {
        return ResponseEntity.status(HttpStatus.OK).body(sectionRepository.findAll());
    }

    public ResponseEntity<Object> findSection(int id) {
        Optional<SectionModel> section = sectionRepository.findById(id);

        if (section.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(section.get());
    }

    public ResponseEntity<Object> updateSection(int id, SectionRecordDTO sectionRecordDTO) {
        Optional<SectionModel> section = sectionRepository.findById(id);

        if (section.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found");
        }

        var sectionModel = new SectionModel();
        BeanUtils.copyProperties(sectionRecordDTO, sectionModel);

        return ResponseEntity.status(HttpStatus.OK).body(sectionRepository.save(sectionModel));
    }

    public ResponseEntity<Object> deleteSection(int id) {
        Optional<SectionModel> section = sectionRepository.findById(id);

        if (section.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found");
        }

        sectionRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Section deleted successfully");
    }
}
