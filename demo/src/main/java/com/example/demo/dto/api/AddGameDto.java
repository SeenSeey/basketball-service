package com.example.demo.dto.api;

import jakarta.validation.constraints.*;

import java.util.Date;

public class AddGameDto {
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;
    private Date dateOfGame;

    public AddGameDto(int scoreHomeTeam, int scoreVisitorTeam, String stadiumName, Date dateOfGame) {
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
        this.dateOfGame = dateOfGame;
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
