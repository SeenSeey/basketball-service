package com.example.basketball_contracts.viewmodel.homePage;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record HomePageViewModel(
        BaseViewModel base,
        List<LastGameViewModel> lastGames,
        List<BestPlayerGameViewModel> bestPlayers,
        BestPlayerViewModel bestPlayerSeason
) {
}
