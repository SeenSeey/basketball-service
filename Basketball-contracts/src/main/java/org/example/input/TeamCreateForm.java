package org.example.input;

import jakarta.validation.constraints.NotBlank;

public record TeamCreateForm (
    @NotBlank(message = "Введите название команды")
    String name,

    @NotBlank(message = "Выберите конференцию")
    String conference,

    @NotBlank(message = "Укажите количество побед в сезоне")
    int winsInSeason,

    @NotBlank(message = "Укажите количество поражений в сезоне")
    int loosesInSeason
) {
}