package org.example.viewmodel.game;

import org.example.viewmodel.base.BaseViewModel;

public record GameDetailsViewModel(
        BaseViewModel base,
        GameViewModel game
) {
}
