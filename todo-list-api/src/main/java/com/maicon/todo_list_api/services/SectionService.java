package com.maicon.todo_list_api.services;

import com.maicon.todo_list_api.dtos.SectionRecordDTO;
import com.maicon.todo_list_api.models.ListModel;
import com.maicon.todo_list_api.models.SectionModel;
import com.maicon.todo_list_api.repositories.ListRepository;
import com.maicon.todo_list_api.repositories.SectionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    ListRepository listRepository;

    public ResponseEntity<Object> createSection(SectionRecordDTO sectionRecordDTO) {
        var sectionModel = new SectionModel();
        BeanUtils.copyProperties(sectionRecordDTO, sectionModel);

        Optional<ListModel> list = listRepository.findById(sectionRecordDTO.idList());

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        } else {
            sectionModel.setList(list.get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(sectionRepository.save(sectionModel));
    }

    public ResponseEntity<Object> updateSection(int id, SectionRecordDTO sectionRecordDTO) {
        boolean sectionExists = sectionRepository.existsById(id);

        if (!sectionExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found");
        }

        var sectionModel = new SectionModel();
        BeanUtils.copyProperties(sectionRecordDTO, sectionModel);
        sectionModel.setIdSection(id);

        Optional<ListModel> list = listRepository.findById(sectionRecordDTO.idList());

        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
        } else {
            sectionModel.setList(list.get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(sectionRepository.save(sectionModel));
    }

    public ResponseEntity<Object> deleteSection(int id) {
        boolean sectionExists = sectionRepository.existsById(id);

        if (!sectionExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Section not found");
        }

        sectionRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Section deleted successfully");
    }
}
