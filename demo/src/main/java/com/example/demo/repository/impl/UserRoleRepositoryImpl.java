package com.example.demo.repository.impl;

import com.example.demo.models.Role;
import com.example.demo.models.enums.UserRoles;
import com.example.demo.repository.UserRoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Role> findRoleByName(UserRoles role) {
        Role result = entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name", Role.class)
                .setParameter("name", role)
                .getSingleResult();
        return Optional.ofNullable(result);
    }

    @Override
    public Long count() {
        return (Long) entityManager.createQuery("SELECT COUNT(r) FROM Role r")
                .getSingleResult();
    }

    @Override
    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }
}
