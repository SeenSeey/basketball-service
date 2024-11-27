package com.example.demo.dto;

public class BestPlayerInLastGameDto {
    private String fullName;
    private int points;
    private int passes;
    private int blocks;

    public BestPlayerInLastGameDto(String fullName, int points, int passes, int blocks) {
        this.fullName = fullName;
        this.points = points;
        this.passes = passes;
        this.blocks = blocks;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPoints() {
        return points;
    }

    public int getPasses() {
        return passes;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPasses(int assists) {
        this.passes = passes;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }
}
