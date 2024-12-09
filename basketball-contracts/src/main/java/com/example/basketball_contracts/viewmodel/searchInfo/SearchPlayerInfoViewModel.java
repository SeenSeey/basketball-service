package com.example.basketball_contracts.viewmodel.searchInfo;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record SearchPlayerInfoViewModel(
        BaseViewModel base,

        Double avPoints,
        Double avAssists,
        Double avBlocks,

        List<String> teamNames,

        int maxPoints,
        int maxAssists,
        int maxBlocks
) {
}