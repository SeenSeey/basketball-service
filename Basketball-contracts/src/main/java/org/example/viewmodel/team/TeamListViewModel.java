package org.example.viewmodel.team;

import org.example.viewmodel.base.BaseViewModel;

import java.util.List;

public record TeamListViewModel(
        BaseViewModel base,
        List<TeamViewModel> teams,
        Integer totalPages
) {
}
