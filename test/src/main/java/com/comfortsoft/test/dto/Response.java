package com.comfortsoft.test.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    @Schema(
            description = "Найденное N-ное минимальное число",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "42"
    )
    private Long value;
}