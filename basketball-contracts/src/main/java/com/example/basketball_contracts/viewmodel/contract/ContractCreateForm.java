package com.example.basketball_contracts.viewmodel.contract;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record ContractCreateForm (
    @NotNull
    int playerId,

    @NotBlank(message = "Введите id команды")
    String team,

    @Min(value = 0, message = "Зарпалата не может быть отрицательной")
    int salaryPerYear,

    @NotNull
    LocalDate contractStartDate,

    @NotNull
    LocalDate contractEndDate
) {
}
