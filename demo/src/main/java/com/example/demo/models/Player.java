package com.example.demo.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player extends BaseEntity {
    private String fullName;
    private String height;
    private String country;
    private int age;
    private Set<Contract> contracts;
    private Set<Performance> performances;

    protected Player() {}

    public Player(String fullName, String height, String country, int age) {
        this.fullName = fullName;
        this.height = height;
        this.country = country;
        this.age = age;
    }

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    public Set<Contract> getContracts() {
        return contracts;
    }

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    public Set<Performance> getPerformances() {
        return performances;
    }

    @Column(name =  "full_name")
    public String getFullName() {
        return fullName;
    }

    @Column(name = "height")
    public String getHeight() {
        return height;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
