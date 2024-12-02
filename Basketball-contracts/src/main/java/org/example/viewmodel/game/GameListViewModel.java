package org.example.viewmodel.game;

import org.example.viewmodel.base.BaseViewModel;

import java.util.List;

public record GameListViewModel(
        BaseViewModel base,
        List<GameViewModel> games,
        Integer totalPages
) {
}
