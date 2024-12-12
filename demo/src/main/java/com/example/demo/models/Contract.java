package com.example.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {
    private Player player;
    private Team team;
    private int salaryPerYear;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;

    public Contract() {}

    public Contract(int salaryPerYear, LocalDate contractStartDate, LocalDate contractEndDate) {
        this.salaryPerYear = salaryPerYear;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    @ManyToOne()
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    @ManyToOne()
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    @Column(name = "salary_per_year")
    public int getSalaryPerYear() {
        return salaryPerYear;
    }

    @Column(name = "contract_start_date")
    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    @Column(name = "contract_end_date")
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setSalaryPerYear(int salaryPerYear) {
        this.salaryPerYear = salaryPerYear;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}
