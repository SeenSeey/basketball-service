package com.example.basketball_contracts.viewmodel.homePage;

import java.time.LocalDate;

public record LastGameViewModel(
        String teamNameH,
        String teamNameV,
        int scoreH,
        int scoreV,
        LocalDate timeOfGame
) {
}