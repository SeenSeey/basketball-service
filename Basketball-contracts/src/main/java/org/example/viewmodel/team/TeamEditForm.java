package org.example.viewmodel.team;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record TeamEditForm(
        int id,

        @NotBlank(message = "Введите название команды")
        String name,

        @NotBlank(message = "Выберите конференцию")
        String conference,

        @Min(value = 0, message = "Количество побед должно быть положительным")
        int winsInSeason,

        @Min(value = 0, message = "Количество поражений должно быть положительным")
        int loosesInSeason
) {
}
