package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {
    private Player player;
    private Team team;
    private int salaryPerYear;
    private Date contractStartDate;
    private Date contractEndDate;

    protected Contract() {}

    public Contract(int salaryPerYear, Date contractStartDate, Date contractEndDate) {
        this.salaryPerYear = salaryPerYear;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    @Column(name = "salary_per_year")
    public int getSalaryPerYear() {
        return salaryPerYear;
    }

    @Column(name = "contract_start_date")
    public Date getContractStartDate() {
        return contractStartDate;
    }

    @Column(name = "contract_end_date")
    public Date getContractEndDate() {
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

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }
}
