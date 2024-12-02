package org.example.viewmodel.contract;

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
