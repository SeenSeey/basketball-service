package com.example.basketball_contracts.viewmodel.performance;

import jakarta.validation.constraints.Min;

public record PerformanceCreateForm (
        @Min(value = 0, message = "Id не может быть отрицательным")
        int playerId,

        @Min(value = 0, message = "Id не может быть отрицательным")
        int gameId,

        @Min(value = 0, message = "Очки не могут быть отрицательными")
        int points,

        @Min(value = 0, message = "Блоки не могут быть отрицательными")
        int blocks,

        @Min(value = 0, message = "Пасы не могут быть отрицательными")
        int passes,

        @Min(value = 0, message = "Трёхочковые броски не могут быть отрицательными")
        int threePointsShots
) {
}