package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskRecordDTO(
        @NotNull int idList,
        int idSection,
        @NotBlank String name,
        String description,
        LocalDateTime dueDate,
        @NotNull boolean done,
        LocalDateTime finishedDate
) {}
