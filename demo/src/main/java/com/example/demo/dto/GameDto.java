package com.example.demo.dto;

import jakarta.validation.constraints.*;

import java.util.Date;

public class GameDto {
    private int id;
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;
    private Date dateOfGame;

    public GameDto(int id, int scoreHomeTeam, int scoreVisitorTeam, String stadiumName, Date dateOfGame) {
        this.id = id;
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
        this.dateOfGame = dateOfGame;
    }

    @NotNull
    @NotEmpty
    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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
