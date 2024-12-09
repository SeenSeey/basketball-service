package com.example.basketball_contracts.viewmodel.contract;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

import java.util.List;

public record ContractListViewModel(
        BaseViewModel base,
        List<ContractViewModel> contracts,
        Integer totalPages
) {
}
