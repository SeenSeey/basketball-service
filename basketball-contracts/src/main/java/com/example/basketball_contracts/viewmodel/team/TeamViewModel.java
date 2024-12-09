package com.example.basketball_contracts.viewmodel.team;

public record TeamViewModel(
        int id,
        String name,
        String conference,
        int winsInSeason,
        int loosesInSeason
) {
}
