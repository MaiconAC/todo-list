package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record ListAccountRecordDTO(@NotBlank int idList, @NotBlank int idAccount) {
}
