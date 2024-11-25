package org.example.input;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public record ContractCreateForm (
    @NotBlank(message = "Введите id игрока")
    int playerId,

    @NotBlank(message = "Введите id команды")
    int teamId,

    @NotBlank(message = "Введите зарплату за год")
    int salaryPerYear,

    @NotBlank(message = "Введите дату начала контракта")
    Date contractStartDate,

    @NotBlank(message = "Введите дату окончания контракта")
    Date contractEndDate
) {
}
