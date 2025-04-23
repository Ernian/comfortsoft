package com.comfortsoft.test.controller;

import com.comfortsoft.test.dto.Request;
import com.comfortsoft.test.dto.Response;
import com.comfortsoft.test.service.AppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Методы контроллера")
@RequestMapping("/get-nth-min")
public class Controller {
    private final AppService service;

    @PostMapping
    @Operation(
            description = """
                    Метод принимает на вход (абсолютный) путь к локальному файлу в формате xlsx и число N.
                    В файле в столбик находятся целые числа (на первом листе, в первом столбце).
                    Сервер возвращает N-ное минимальное число из файла
                    """
    )
    public Response controller(@Valid @RequestBody Request request) {
        return service.getNthMin(request);
    }
}