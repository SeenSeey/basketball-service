package org.example.viewmodel.homePage;

import org.example.viewmodel.base.BaseViewModel;

public record HomePageViewModel(
        BaseViewModel base,
        NbaLastGameViewModel lastGames,
        BestPlayerViewModel bestPlayerSeason
) {
}
