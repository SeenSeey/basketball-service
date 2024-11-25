package org.example.viewmodel.homePage;

import java.util.Date;

public record LastGameViewModel(
        String teamNameH,
        String teamNameV,
        int scoreH,
        int scoreV,
        Date timeOfGame
) {
}
