package com.example.demo.repository.impl;

import com.example.demo.models.Team;
import com.example.demo.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepositoryImpl implements TeamRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private TeamRepository teamRepository;

    @Override
    public Team save(Team team) {
        entityManager.persist(team);
        return team;
    }

    @Override
    public Optional<Team> update(Team team) {
        return Optional.of(entityManager.merge(team));
    }

    @Override
    public Optional<Team> findTeamByPlayerFullName(String fullName) {
        return teamRepository.findTeamByPlayerFullName(fullName);
    }

    @Override
    public List<Team> findTeamByGameId(int id) {
        return teamRepository.findTeamByGameId(id);
    }

    @Override
    public Optional<Team> findById(int id) {
        return teamRepository.findById(id);
    }
}
