package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginAccountRecordDTO(
        @NotBlank String email,
        @NotBlank String password
) {
}
