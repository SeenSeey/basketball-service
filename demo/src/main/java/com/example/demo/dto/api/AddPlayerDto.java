package com.example.demo.dto.api;

public class AddPlayerDto {
    private String fullName;
    private String height;
    private String country;
    private int age;

    public AddPlayerDto(String fullName, String height, String country, int age) {
        this.fullName = fullName;
        this.height = height;
        this.country = country;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getHeight() {
        return height;
    }

    public String getCountry() {
        return country;
    }

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
}
