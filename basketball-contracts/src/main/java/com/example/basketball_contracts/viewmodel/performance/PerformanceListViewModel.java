package com.example.basketball_contracts.viewmodel.performance;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record PerformanceListViewModel(
        BaseViewModel base,
        List<PerformanceViewModel> performances,
        Integer totalPages
) {
}
