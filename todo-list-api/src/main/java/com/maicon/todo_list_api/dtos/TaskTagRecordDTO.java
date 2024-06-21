package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record TaskTagRecordDTO(@NotBlank int idTask, @NotBlank int idTag) {
}
