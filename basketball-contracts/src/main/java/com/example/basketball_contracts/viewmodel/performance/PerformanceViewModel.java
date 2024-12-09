package com.example.basketball_contracts.viewmodel.performance;

public record PerformanceViewModel(
        int id,
        int playerId,
        int gameId,
        int points,
        int blocks,
        int passes,
        int threePointsShots
) {
}