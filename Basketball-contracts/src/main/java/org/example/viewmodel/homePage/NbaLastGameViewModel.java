package org.example.viewmodel.homePage;

import java.util.List;

public record NbaLastGameViewModel(
        List<LastGameViewModel> lastGames,
        List<BestPlayerGameViewModel> bestPlayers
) {
}
