package org.example.viewmodel.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeamCreateForm (
    @NotBlank(message = "Введите название команды")
    String name,

    @NotBlank(message = "Выберите конференцию")
    String conference,

    @NotNull
    int winsInSeason,

    @NotNull
    int loosesInSeason
) {
}