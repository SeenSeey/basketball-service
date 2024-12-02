package org.example.viewmodel.game;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record GameEditForm(
        @NotNull
        int id,

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

        @NotNull
        LocalDate dateOfGame
) {
}
