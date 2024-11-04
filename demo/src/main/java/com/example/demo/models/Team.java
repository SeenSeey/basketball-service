package com.example.demo.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {
    private Set<Game> games;
    private Set<Contract> contracts;
    private String name;
    private String conference;
    private int winsInSeason;
    private int loosesInSeason;

    protected Team() {}

    public Team(String name, String conference, int winsInSeason, int loosesInSeason) {
        this.name = name;
        this.conference = conference;
        this.winsInSeason = winsInSeason;
        this.loosesInSeason = loosesInSeason;
    }

    @ManyToMany(mappedBy = "teams", targetEntity = Game.class)
    public Set<Game> getGames() {
        return games;
    }

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    public Set<Contract> getContracts() {
        return contracts;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "conference")
    public String getConference() {
        return conference;
    }

    @Column(name = "wins_in_season")
    public int getWinsInSeason() {
        return winsInSeason;
    }

    @Column(name = "looses_in_season")
    public int getLoosesInSeason() {
        return loosesInSeason;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public void setWinsInSeason(int winsInSeason) {
        this.winsInSeason = winsInSeason;
    }

    public void setLoosesInSeason(int loosesInSeason) {
        this.loosesInSeason = loosesInSeason;
    }
}
