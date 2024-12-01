package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerDto {
    private int id;
    private String fullName;
    private String height;
    private String country;
    private int age;

    public PlayerDto(int id, String fullName, String height, String country, int age) {
        this.id = id;
        this.fullName = fullName;
        this.height = height;
        this.country = country;
        this.age = age;
    }

    protected PlayerDto() {}

    @NotNull
    public int getId() {
        return id;
    }

    @NotNull
    @NotEmpty
    @Size(min = 4, message = ("Player`s full name must be more than four characters!"))
    public String getFullName() {
        return fullName;
    }

    @NotNull
    @NotEmpty
    public String getHeight() {
        return height;
    }

    @NotNull
    @NotEmpty
    @Size(min = 2, message = "Country must be more than two characters!")
    public String getCountry() {
        return country;
    }

    @Min(value = 17, message = "Player can`t be younger than 17")
    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
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
}
