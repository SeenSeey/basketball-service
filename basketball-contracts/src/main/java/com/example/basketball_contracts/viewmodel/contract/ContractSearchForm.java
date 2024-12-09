package com.example.basketball_contracts.viewmodel.contract;

import jakarta.validation.constraints.Min;

public record ContractSearchForm(
        @Min(value = 0, message = "Страница должна быть больше 0")
        Integer page,
        @Min(value = 1, message = "Размер страницы должен быть больше 0")
        Integer size
) {
}
