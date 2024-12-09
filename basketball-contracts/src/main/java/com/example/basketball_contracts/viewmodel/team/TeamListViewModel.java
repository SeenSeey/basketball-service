package com.example.basketball_contracts.viewmodel.team;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record TeamListViewModel(
        BaseViewModel base,
        List<TeamViewModel> teams,
        Integer totalPages
) {
}
