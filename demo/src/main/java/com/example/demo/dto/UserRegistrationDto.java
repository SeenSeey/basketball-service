package com.example.demo.dto;

import com.example.demo.utils.validation.UniqueEmail;
import com.example.demo.utils.validation.UniqueUsername;
import jakarta.validation.constraints.*;

public class UserRegistrationDto {
    @UniqueUsername
    private String username;
    private String fullName;
    @UniqueEmail
    private String email;
    private int age;
    private String password;
    private String confirmPassword;

    public UserRegistrationDto() {}

    @NotEmpty(message = "User name cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getUsername() {
        return username;
    }

    @NotEmpty(message = "Full name cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getFullName() {
        return fullName;
    }

    @NotEmpty(message = "Email cannot be null or empty!")
    @Email
    public String getEmail() {
        return email;
    }

    @Min(0)
    @Max(90)
    public int getAge() {
        return age;
    }

    @NotEmpty(message = "Password cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getPassword() {
        return password;
    }

    @NotEmpty(message = "Confirm Password cannot be null or empty!")
    @Size(min = 5, max = 20)
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
