package com.example.demo.dto.api;

import jakarta.validation.constraints.*;

public class AddPerformanceDto {
    private int playerId;
    private int gameId;
    private int points;
    private int blocks;
    private int passes;
    private int threePointsShots;

    public AddPerformanceDto(int playerId, int gameId, int points, int blocks, int passes, int threePointsShots) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.points = points;
        this.blocks = blocks;
        this.passes = passes;
        this.threePointsShots = threePointsShots;
    }

    @NotNull
    public int getPlayerId() {
        return playerId;
    }

    @NotNull
    public int getGameId() {
        return gameId;
    }

    @Min(value = 0, message = "Points can`t be negative")
    @Max(value = 120)
    public int getPoints() {
        return points;
    }

    @Min(value = 0, message = "Blocks can`t be negative")
    @Max(value = 40)
    public int getBlocks() {
        return blocks;
    }

    @Min(value = 0, message = "Passes can`t be negative")
    @Max(value = 40)
    public int getPasses() {
        return passes;
    }

    @Min(value = 0, message = "Three-points shots  can`t be negative")
    public int getThreePointsShots() {
        return threePointsShots;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public void setThreePointsShots(int threePointsShots) {
        this.threePointsShots = threePointsShots;
    }
}
