package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AccountRecordDTO(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String password
) { }
