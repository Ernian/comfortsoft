package com.comfortsoft.test.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Request {
    @Schema(
            description = "Абсолютный путь к файлу xlsx",
            requiredMode = Schema.RequiredMode.REQUIRED,
            example = "C:/comfortsoft/test/src/main/resources/test.xlsx"
    )
    @NotBlank
    private String path;

    @Schema(
            description = "N-ное минимальное число",
            requiredMode = Schema.RequiredMode.REQUIRED,
            minimum = "1",
            example = "42"
    )
    @Min(1)
    private int nthMin;
}