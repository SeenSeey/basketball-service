package org.example.viewmodel.performance;

import org.example.viewmodel.base.BaseViewModel;

import java.util.List;

public record PerformanceListViewModel(
        BaseViewModel base,
        List<PerformanceViewModel> performances,
        Integer totalPages
) {
}
