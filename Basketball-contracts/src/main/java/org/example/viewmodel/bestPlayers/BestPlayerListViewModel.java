package org.example.viewmodel.bestPlayers;

import org.example.viewmodel.base.BaseViewModel;
import org.example.viewmodel.homePage.BestPlayerViewModel;

import java.util.List;

public record BestPlayerListViewModel(
        BaseViewModel base,
        List<BestPlayerViewModel> bestPlayers
) {
}
