package org.example.viewmodel.contract;

import org.example.viewmodel.base.BaseViewModel;

import java.util.List;

public record ContractListViewModel(
        BaseViewModel base,
        List<ContractViewModel> contracts,
        Integer totalPages
) {
}
