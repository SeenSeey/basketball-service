package org.example.viewmodel.searchInfo;

import org.example.viewmodel.base.BaseViewModel;

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
