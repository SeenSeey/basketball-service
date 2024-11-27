package com.example.demo.dto;

import java.util.Date;

public class LastGameDto {
    private String teamNameHome;
    private int scoreHomeTeam;
    private Date dateOfGame;
    private int scoreVisitorTeam;
    private String teamNameVisit;

    public LastGameDto(String teamNameHome, int scoreHomeTeam, Date dateOfGame, int scoreVisitorTeam, String teamNameVisit) {
        this.teamNameHome = teamNameHome;
        this.scoreHomeTeam = scoreHomeTeam;
        this.dateOfGame = dateOfGame;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.teamNameVisit = teamNameVisit;
    }

    public String getTeamNameHome() {
        return teamNameHome;
    }

    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public Date getDateOfGame() {
        return dateOfGame;
    }

    public int getScoreVisitorTeam() {
        return scoreVisitorTeam;
    }

    public String getTeamNameVisit() {
        return teamNameVisit;
    }

    public void setTeamNameHome(String teamNameHome) {
        this.teamNameHome = teamNameHome;
    }

    public void setScoreHomeTeam(int scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
    }

    public void setDateOfGame(Date dateOfGame) {
        this.dateOfGame = dateOfGame;
    }

    public void setScoreVisitorTeam(int scoreVisitorTeam) {
        this.scoreVisitorTeam = scoreVisitorTeam;
    }

    public void setTeamNameVisit(String teamNameVisit) {
        this.teamNameVisit = teamNameVisit;
    }
}
