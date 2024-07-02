package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskTagRecordDTO(@NotNull int idTask, @NotNull int idTag) {
}
