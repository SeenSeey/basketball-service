package org.example.input;

import jakarta.validation.constraints.NotBlank;

public record PlayerSearchForm(
        @NotBlank(message = "Введите полное имя игрока")
        String fullName
) {
}


