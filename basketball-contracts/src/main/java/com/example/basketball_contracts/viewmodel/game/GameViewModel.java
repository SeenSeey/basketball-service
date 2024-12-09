package com.example.basketball_contracts.viewmodel.game;

import java.time.LocalDate;

public record GameViewModel(
        int id,
        String teamNameHome,
        String teamNameVisit,
        int scoreHomeTeam,
        int scoreVisitTeam,
        String stadiumName,
        LocalDate dateOfGame
) {
}
