package com.example.demo.dto;

public class BestPlayerThisSeasonDto {
    private String fullName;
    private Double avgPoints;
    private Double avgPasses;
    private Double avgBlocks;
    private String teamName;

    public BestPlayerThisSeasonDto(String fullName, Double avgPoints, Double avgPasses, Double avgBlocks, String teamName) {
        this.fullName = fullName;
        this.avgPoints = avgPoints;
        this.avgPasses = avgPasses;
        this.avgBlocks = avgBlocks;
        this.teamName = teamName;
    }

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

    public String getTeamName() {
        return teamName;
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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
