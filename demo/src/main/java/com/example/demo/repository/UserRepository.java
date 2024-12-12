package com.example.demo.repository;

import com.example.demo.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);

    Long count();

    void save(User user);
}
