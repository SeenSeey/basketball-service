package com.example.demo.dto.api;

public class AddTeamDto {
    private String name;
    private String conference;
    private int winsInSeason;
    private int loosesInSeason;

    public AddTeamDto(String name, String conference, int winsInSeason, int loosesInSeason) {
        this.name = name;
        this.conference = conference;
        this.winsInSeason = winsInSeason;
        this.loosesInSeason = loosesInSeason;
    }

    public String getName() {
        return name;
    }

    public String getConference() {
        return conference;
    }

    public int getWinsInSeason() {
        return winsInSeason;
    }

    public int getLoosesInSeason() {
        return loosesInSeason;
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
