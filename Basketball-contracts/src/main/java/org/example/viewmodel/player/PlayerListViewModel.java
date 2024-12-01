package org.example.viewmodel.player;

import org.example.viewmodel.base.BaseViewModel;

import java.util.List;

public record PlayerListViewModel(
        BaseViewModel base,
        List<PlayerViewModel> players,
        Integer totalPages
) {
}
