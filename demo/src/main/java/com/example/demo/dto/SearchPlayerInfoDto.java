package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class SearchPlayerInfoDto {
    private String fullName;
    private Double avgPoints;
    private Double avgPasses;
    private Double avgBlocks;
    private List<String> teamNames;
    private int maxPoints;
    private int maxPasses;
    private int maxBlocks;
    private LocalDate dateOfBestGame;

    public SearchPlayerInfoDto(String fullName, Double avgPoints, Double avgPasses, Double avgBlocks, List<String> teamNames,
                               int maxPoints, int maxPasses, int maxBlocks, LocalDate dateOfBestGame) {
        this.fullName = fullName;
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

    public String getFullName() {
        return fullName;
    }

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

    public LocalDate getDateOfBestGame() {
        return dateOfBestGame;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setDateOfBestGame(LocalDate dateOfBestGame) {
        this.dateOfBestGame = dateOfBestGame;
    }
}
