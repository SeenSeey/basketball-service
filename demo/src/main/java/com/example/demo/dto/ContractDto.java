package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ContractDto {
    private int id;
    private int playerId;
    private int teamId;
    private int salaryPerYear;
    private Date contractStartDate;
    private Date contractEndDate;

    public ContractDto(int id, int playerId, int teamId, int salaryPerYear, Date contractStartDate, Date contractEndDate) {
        this.id = id;
        this.playerId = playerId;
        this.teamId = teamId;
        this.salaryPerYear = salaryPerYear;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    public int getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getTeamId() {
        return teamId;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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
