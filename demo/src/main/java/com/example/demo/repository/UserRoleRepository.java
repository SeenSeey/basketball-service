package com.example.demo.repository;

import com.example.demo.models.Role;
import com.example.demo.models.enums.UserRoles;

import java.util.Optional;

public interface UserRoleRepository {
    Optional<Role> findRoleByName(UserRoles role);

    Long count();

    void save(Role role);
}
