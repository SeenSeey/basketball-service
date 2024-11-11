package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class PerformanceDto {
    private int id;
    private String player;
    private int gameId;
    private int points;
    private int blocks;
    private int passes;
    private int threePointsShots;

    public PerformanceDto(int id, String player, int gameId, int points, int blocks, int passes, int threePointsShots) {
        this.id = id;
        this.player = player;
        this.gameId = gameId;
        this.points = points;
        this.blocks = blocks;
        this.passes = passes;
        this.threePointsShots = threePointsShots;
    }

    public int getId() {
        return id;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Player`s name must be more than two characters!")
    public String getPlayer() {
        return player;
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayer(String player) {
        this.player = player;
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
