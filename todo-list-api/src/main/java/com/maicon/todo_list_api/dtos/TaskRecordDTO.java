package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TaskRecordDTO(
        @NotBlank int idList,
        int idSection,
        @NotBlank String name,
        String description,
        LocalDateTime dueDate,
        @NotBlank boolean done,
        LocalDateTime finishedDate
) {}
