package org.example.viewmodel.homePage;

public record BestPlayerViewModel(
        String fullName,
        Double avPoints,
        Double avAssists,
        Double avBlocks,
        String teamName
) {
}
