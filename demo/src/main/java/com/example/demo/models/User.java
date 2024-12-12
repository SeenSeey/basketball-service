package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private int age;
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public User(String username, String password, String email, String fullName, int age) {
        this();
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.age = age;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Role> getRoles() {
        return roles;
    }

    @Column(nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
