package com.example.demo.dto.api;

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

    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public int getScoreVisitorTeam() {
        return scoreVisitorTeam;
    }

    public String getStadiumName() {
        return stadiumName;
    }

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
