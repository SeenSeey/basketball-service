package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class SearchPlayerInfoDto {
    private Double avgPoints;
    private Double avgPasses;
    private Double avgBlocks;
    private List<String> teamNames;
    private int maxPoints;
    private int maxPasses;
    private int maxBlocks;
    private Date dateOfBestGame;

    public SearchPlayerInfoDto(Double avgPoints, Double avgPasses, Double avgBlocks, List<String> teamNames,
                               int maxPoints, int maxPasses, int maxBlocks, Date dateOfBestGame) {
        this.avgPoints = avgPoints;
        this.avgPasses = avgPasses;
        this.avgBlocks = avgBlocks;
        this.teamNames = teamNames;
        this.maxPoints = maxPoints;
        this.maxPasses = maxPasses;
        this.maxBlocks = maxBlocks;
        this.dateOfBestGame = dateOfBestGame;
    }

    public SearchPlayerInfoDto(){};

    public Double getAvgPoints() {
        return avgPoints;
    }

    public Double getAvgPasses() {
        return avgPasses;
    }

    public Double getAvgBlocks() {
        return avgBlocks;
    }

    public List<String> getTeamNames() {
        return teamNames;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public int getMaxPasses() {
        return maxPasses;
    }

    public int getMaxBlocks() {
        return maxBlocks;
    }

    public Date getDateOfBestGame() {
        return dateOfBestGame;
    }

    public void setAvgPoints(Double avgPoints) {
        this.avgPoints = avgPoints;
    }

    public void setAvgPasses(Double avgPasses) {
        this.avgPasses = avgPasses;
    }

    public void setAvgBlocks(Double avgBlocks) {
        this.avgBlocks = avgBlocks;
    }

    public void setTeamNames(List<String> teamNames) {
        this.teamNames = teamNames;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setMaxPasses(int maxPasses) {
        this.maxPasses = maxPasses;
    }

    public void setMaxBlocks(int maxBlocks) {
        this.maxBlocks = maxBlocks;
    }

    public void setDateOfBestGame(Date dateOfBestGame) {
        this.dateOfBestGame = dateOfBestGame;
    }
}
