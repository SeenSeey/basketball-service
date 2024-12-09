package com.example.basketball_contracts.viewmodel.player;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record PlayerListViewModel(
        BaseViewModel base,
        List<PlayerViewModel> players,
        Integer totalPages
) {
}
