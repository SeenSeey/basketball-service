package org.example.viewmodel.contract;

import org.example.viewmodel.base.BaseViewModel;

public record ContractDetailsViewModel(
        BaseViewModel base,
        ContractViewModel contract
) {
}
