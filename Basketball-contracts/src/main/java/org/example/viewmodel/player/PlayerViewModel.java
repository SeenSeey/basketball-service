package org.example.viewmodel.player;

public record PlayerViewModel(
        int id,
        String fullName,
        int age,
        String height,
        String country
) {
}
