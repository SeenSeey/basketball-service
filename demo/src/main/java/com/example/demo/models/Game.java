package com.example.demo.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game extends BaseEntity {
    public Set<Performance> performances;
    private Set<Team> teams;
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;

    protected Game() {}

    public Game(int scoreHomeTeam, int scoreVisitorTeam, String stadiumName) {
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
    }

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    public Set<Performance> getPerformances() {
        return performances;
    }

    @ManyToMany
    @JoinTable(
            name = "game_team",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    public Set<Team> getTeams() {
        return teams;
    }

    @Column(name = "score_home_team")
    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    @Column(name = "score_visitor_team")
    public int getScoreVisitorTeam() {
        return scoreVisitorTeam;
    }

    @Column(name = "stadium")
    public String getStadiumName() {
        return stadiumName;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
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
}
