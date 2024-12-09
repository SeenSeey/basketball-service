package com.example.basketball_contracts.viewmodel.searchInfo;

import jakarta.validation.constraints.NotBlank;

public record PlayerInfoSearchForm(
        @NotBlank(message = "Введите полное имя игрока")
        String fullName
) {
}

