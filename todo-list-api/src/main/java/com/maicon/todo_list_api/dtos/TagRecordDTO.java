package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TagRecordDTO(@NotBlank String description) {
}
