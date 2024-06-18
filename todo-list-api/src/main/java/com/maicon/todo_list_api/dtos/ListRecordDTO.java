package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record ListRecordDTO(@NotBlank String listTitle, @NotBlank int idAdmin) {}
