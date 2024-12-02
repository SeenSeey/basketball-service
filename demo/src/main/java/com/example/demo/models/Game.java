package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game extends BaseEntity {
    public Set<Performance> performance;
    private Set<Team> team;
    private int scoreHomeTeam;
    private int scoreVisitorTeam;
    private String stadiumName;
    private LocalDate dateOfGame;

    protected Game() {}

    public Game(int scoreHomeTeam, int scoreVisitorTeam, String stadiumName, LocalDate dateOfGame) {
        this.scoreHomeTeam = scoreHomeTeam;
        this.scoreVisitorTeam = scoreVisitorTeam;
        this.stadiumName = stadiumName;
        this.dateOfGame = dateOfGame;
    }

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    public Set<Performance> getPerformance() {
        return performance;
    }

    @ManyToMany
    @JoinTable(
            name = "game_team",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    public Set<Team> getTeam() {
        return team;
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

    @Column(name = "date_of_game")
    public LocalDate getDateOfGame() {
        return dateOfGame;
    }

    public void setPerformance(Set<Performance> performances) {
        this.performance = performances;
    }

    public void setTeam(Set<Team> teams) {
        this.team = teams;
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

    public void setDateOfGame(LocalDate dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
}
