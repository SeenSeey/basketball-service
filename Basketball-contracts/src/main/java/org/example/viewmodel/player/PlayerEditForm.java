package org.example.viewmodel.player;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlayerEditForm (
        int id,

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
