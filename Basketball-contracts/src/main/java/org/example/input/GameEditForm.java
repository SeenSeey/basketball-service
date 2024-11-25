package org.example.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record GameEditForm(
        @NotBlank(message = "Идентификатор обязателен")
        int gameId,

        @NotBlank(message = "Введите название домашней команды")
        String homeTeam,

        @NotBlank(message = "Введите название гостевой команды")
        String visitTeam,

        @Min(value = 0, message = "Счёт домашней команды должен быть больше 0")
        int scoreHomeTeam,

        @Min(value = 0, message = "Счёт гостевой команды должен быть больше 0")
        int scoreVisitTeam,

        @NotBlank(message = "Введите название стадиона")
        String stadiumName,

        @NotBlank(message = "Введите дату игры")
        Date dateOfGame
) {
}