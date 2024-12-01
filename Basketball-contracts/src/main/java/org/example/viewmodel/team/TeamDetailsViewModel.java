package org.example.viewmodel.team;

import org.example.viewmodel.base.BaseViewModel;

public record TeamDetailsViewModel(
        BaseViewModel base,
        TeamViewModel team
) {
}
