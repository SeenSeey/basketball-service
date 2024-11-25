package org.example.viewmodel.homePage;

public record BestPlayerGameViewModel(
        String fullName,
        int points,
        int assists,
        int blocks
) {
}
