package com.example.basketball_contracts.viewmodel.searchInfo;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record PlayerInfoViewModel(
        BaseViewModel base,
        List<SearchPlayerInfoViewModel> players,
        String fullName
) {
}
