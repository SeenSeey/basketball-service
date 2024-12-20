package com.example.demo.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class GameDto {
    private int id;
    private String teamNameHome;
    private String teamNameVisit;
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;
    private LocalDate dateOfGame;

    public GameDto(int id, String teamNameHome, String teamNameVisit,
                   int scoreHomeTeam, int scoreVisitorTeam, String stadiumName, LocalDate dateOfGame) {
        this.id = id;
        this.teamNameHome = teamNameHome;
        this.teamNameVisit = teamNameVisit;
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
        this.dateOfGame = dateOfGame;
    }

    protected GameDto() {}

    @NotNull
    public int getId() {
        return id;
    }

    @NotNull
    @Size(min = 3, message = "Team name can`t be so short")
    public String getTeamNameHome() {
        return teamNameHome;
    }

    @NotNull
    @Size(min = 3, message = "Team name can`t be so short")
    public String getTeamNameVisit() {
        return teamNameVisit;
    }

    @Min(value = 0, message = "The score can`t be negative")
    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    @Min(value = 0, message = "The score can`t be negative")
    public int getScoreVisitorTeam() {
        return scoreVisitorTeam;
    }

    @NotNull
    @Size(min = 2, message = "Stadium name must be more than two characters!")
    public String getStadiumName() {
        return stadiumName;
    }

    public LocalDate getDateOfGame() {
        return dateOfGame;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamNameHome(String teamNameHome) {
        this.teamNameHome = teamNameHome;
    }

    public void setTeamNameVisit(String teamNameVisit) {
        this.teamNameVisit = teamNameVisit;
    }

    public void setScoreHomeTeam(int scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
    }

    public void setScoreVisitorTeam(int scoreVisitorTeam) {
        this.scoreVisitorTeam = scoreVisitorTeam;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setDateOfGame(LocalDate dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
}
