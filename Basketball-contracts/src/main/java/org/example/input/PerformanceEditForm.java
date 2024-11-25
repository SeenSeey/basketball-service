package org.example.input;

import jakarta.validation.constraints.NotBlank;

public record PerformanceEditForm(
        @NotBlank(message = "Идентификатор обязателен")
        int performanceId,

        @NotBlank(message = "Введите id игрока")
        int playerId,

        @NotBlank(message = "Введите id команды")
        int gameId,

        @NotBlank(message = "Введите количество очков за игру")
        int points,

        @NotBlank(message = "Введите количество блоков за игру")
        int blocks,

        @NotBlank(message = "Введите количество пассов за игру")
        int passes,

        @NotBlank(message = "Введите количество трёхочковых бросков за игру")
        int threePointsShots
) {
}
