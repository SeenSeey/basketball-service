package com.example.basketball_contracts.viewmodel.bestPlayers;

import com.example.basketball_contracts.viewmodel.homePage.BestPlayerViewModel;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record BestPlayerListViewModel(
        BaseViewModel base,
        List<BestPlayerViewModel> bestPlayers
) {
}