package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TeamDto {
    private int id;
    private String name;
    private String conference;
    private int winsInSeason;
    private int loosesInSeason;

    public TeamDto(int id, String name, String conference, int winsInSeason, int loosesInSeason) {
        this.id = id;
        this.name = name;
        this.conference = conference;
        this.winsInSeason = winsInSeason;
        this.loosesInSeason = loosesInSeason;
    }

    protected TeamDto() {}

    @NotNull
    public int getId() {
        return id;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Team`s name can`t be shorter than two characters!")
    public String getName() {
        return name;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Conference`s name can`t be shorter than two characters!")
    public String getConference() {
        return conference;
    }

    @Min(value = 0, message = "Wins count can`t be negative")
    public int getWinsInSeason() {
        return winsInSeason;
    }

    @Min(value = 0, message = "Looses count can`t be negative")
    public int getLoosesInSeason() {
        return loosesInSeason;
    }

    public void setId(int id) {
        this.id = id;
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
