package com.example.basketball_contracts.viewmodel.contract;

import java.time.LocalDate;

public record ContractViewModel(
        int id,
        int playerId,
        String team,
        int salaryPerYear,
        LocalDate contractStartDate,
        LocalDate contractEndDate
) {
}
