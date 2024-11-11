package com.example.demo.dto.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class AddContractDto {
    private String player;
    private String team;
    private int salaryPerYear;
    private Date contractStartDate;
    private Date contractEndDate;

    public AddContractDto(String player, String team, int salaryPerYear, Date contractStartDate, Date contractEndDate) {
        this.player = player;
        this.team = team;
        this.salaryPerYear = salaryPerYear;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Player`s name must be more than two characters!")
    public String getPlayer() {
        return player;
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

    public void setPlayer(String player) {
        this.player = player;
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

