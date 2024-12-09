package com.example.basketball_contracts.viewmodel.performance;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

public record PerformanceDetailsViewModel(
        BaseViewModel base,
        PerformanceViewModel performance
) {
}
