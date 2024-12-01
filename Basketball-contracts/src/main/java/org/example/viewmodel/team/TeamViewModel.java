package org.example.viewmodel.team;

public record TeamViewModel(
        int id,
        String name,
        String conference,
        int winsInSeason,
        int loosesInSeason
) {
}
