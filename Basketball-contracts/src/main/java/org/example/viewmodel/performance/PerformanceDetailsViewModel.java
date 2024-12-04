package org.example.viewmodel.performance;

import org.example.viewmodel.base.BaseViewModel;

public record PerformanceDetailsViewModel(
        BaseViewModel base,
        PerformanceViewModel performance
) {
}
