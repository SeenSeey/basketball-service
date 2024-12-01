package org.example.viewmodel.player;

import org.example.viewmodel.base.BaseViewModel;

public record PlayerDetailsViewModel(
        BaseViewModel base,
        PlayerViewModel player
) {
}
