package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListRecordDTO(@NotBlank String listTitle, @NotNull int idAdmin) {}
