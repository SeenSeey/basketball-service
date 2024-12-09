package com.example.basketball_contracts.viewmodel.homePage;

public record BestPlayerViewModel(
        String fullName,
        Double avPoints,
        Double avAssists,
        Double avBlocks,
        String teamName
) {
}

