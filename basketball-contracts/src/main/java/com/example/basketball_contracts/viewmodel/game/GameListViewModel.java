package com.example.basketball_contracts.viewmodel.game;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record GameListViewModel(
        BaseViewModel base,
        List<GameViewModel> games,
        Integer totalPages
) {
}