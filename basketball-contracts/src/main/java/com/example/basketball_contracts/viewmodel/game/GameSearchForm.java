package com.example.basketball_contracts.viewmodel.game;

import jakarta.validation.constraints.Min;

public record GameSearchForm(
        @Min(value = 0, message = "Страница должна быть больше 0")
        Integer page,
        @Min(value = 1, message = "Размер страницы должен быть больше 0")
        Integer size
) {
}
