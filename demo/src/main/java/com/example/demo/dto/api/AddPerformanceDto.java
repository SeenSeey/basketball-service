package com.example.demo.dto.api;

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

    public int getPlayerId() {
        return playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPoints() {
        return points;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getPasses() {
        return passes;
    }

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
