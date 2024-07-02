package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotNull;

public record ListAccountRecordDTO(@NotNull int idList, @NotNull int idAccount) {
}
