package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "performance")
public class Performance extends BaseEntity {
    private Player player;
    private Game game;
    private int points;
    private int blocks;
    private int passes;
    private int threePointsShots;

    protected Performance() {}

    public Performance(int points, int blocks, int passes, int threePointsShots) {
        this.points = points;
        this.blocks = blocks;
        this.passes = passes;
        this.threePointsShots = threePointsShots;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    public Game getGame() {
        return game;
    }

    @Column(name = "points")
    public int getPoints() {
        return points;
    }

    @Column(name = "blocks")
    public int getBlocks() {
        return blocks;
    }

    @Column(name = "passes")
    public int getPasses() {
        return passes;
    }

    @Column(name = "three_points_shots")
    public int getThreePointsShots() {
        return threePointsShots;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGame(Game game) {
        this.game = game;
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
