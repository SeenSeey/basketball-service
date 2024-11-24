package com.example.demo.dto.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class AddContractDto {
    private int playerId;
    private String team;
    private int salaryPerYear;
    private Date contractStartDate;
    private Date contractEndDate;

    public AddContractDto(int id, int playerId, String team, int salaryPerYear, Date contractStartDate, Date contractEndDate) {
        this.playerId = playerId;
        this.team = team;
        this.salaryPerYear = salaryPerYear;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    @NotNull
    @NotEmpty
    public int getPlayerId() {
        return playerId;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Team`s name must be more than two characters!")
    public String getTeam() {
        return team;
    }

    @NotNull
    @Min(value = 0, message = "The salary can`t be negative")
    public int getSalaryPerYear() {
        return salaryPerYear;
    }

    @NotNull
    @NotEmpty
    public Date getContractStartDate() {
        return contractStartDate;
    }

    @NotNull
    @NotEmpty
    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setSalaryPerYear(int salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}

