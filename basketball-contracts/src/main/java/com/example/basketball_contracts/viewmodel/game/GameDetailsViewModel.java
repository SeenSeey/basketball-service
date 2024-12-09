package com.example.basketball_contracts.viewmodel.game;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

public record GameDetailsViewModel(
        BaseViewModel base,
        GameViewModel game
) {
}
