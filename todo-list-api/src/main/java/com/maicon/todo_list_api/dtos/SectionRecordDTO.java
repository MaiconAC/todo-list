package com.maicon.todo_list_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SectionRecordDTO(@NotBlank String sectionTitle, @NotNull int idList) {
}
