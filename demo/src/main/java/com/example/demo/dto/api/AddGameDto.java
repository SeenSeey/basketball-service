package com.example.demo.dto.api;

import jakarta.validation.constraints.*;

import java.util.Date;

public class AddGameDto {
    private String teamNameHome;
    private String teamNameVisit;
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;
    private Date dateOfGame;

    public AddGameDto( String teamNameHome, String teamNameVisit,
                   int scoreHomeTeam, int scoreVisitorTeam, String stadiumName, Date dateOfGame) {
        this.teamNameHome = teamNameHome;
        this.teamNameVisit = teamNameVisit;
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
        this.dateOfGame = dateOfGame;
    }

    @NotNull
    @NotEmpty
    @Size(min = 3, message = "Team name can`t be so short")
    public String getTeamNameHome() {
        return teamNameHome;
    }

    @NotNull
    @NotEmpty
    @Size(min = 3, message = "Team name can`t be so short")
    public String getTeamNameVisit() {
        return teamNameVisit;
    }

    @Min(value = 0, message = "The score can`t be negative")
    @Max(value = 200)
    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    @Min(value = 0, message = "The score can`t be negative")
    @Max(value = 200)
    public int getScoreVisitorTeam() {
        return scoreVisitorTeam;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Stadium name must be more than two characters!")
    public String getStadiumName() {
        return stadiumName;
    }

    @NotNull
    @NotEmpty
    public Date getDateOfGame() {
        return dateOfGame;
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

    public void setDateOfGame(Date dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
}

