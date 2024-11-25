package org.example.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PlayerEditForm (
        @NotBlank(message = "Идентификатор обязателен")
        int playerId,

        @NotBlank(message = "Введите полное имя")
        String fullName,

        @Min(value = 17, message = "Возраст должен быть больше 17")
        int age,

        @NotBlank(message = "Укажите рост")
        String height,

        @NotBlank(message = "Укажите родную страну игрока")
        String country
) {
}
