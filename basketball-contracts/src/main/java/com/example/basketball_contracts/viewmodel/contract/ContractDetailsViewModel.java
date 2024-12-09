package com.example.basketball_contracts.viewmodel.contract;

import com.example.basketball_contracts.viewmodel.base.BaseViewModel;

public record ContractDetailsViewModel(
        BaseViewModel base,
        ContractViewModel contract
) {
}
