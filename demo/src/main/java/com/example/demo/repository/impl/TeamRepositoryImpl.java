package com.example.demo.repository.impl;

import com.example.demo.models.Team;
import com.example.demo.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    public Team update(Team team) {
        return entityManager.merge(team);
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
    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public Optional<Team> findById(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return teamRepository.findAll(pageable);
    }

    @Override
    public Page<Team> findByTitleContainingIgnoreCase(String searchTerm, Pageable pageable) {
        return teamRepository.findByTitleContainingIgnoreCase(searchTerm, pageable);
    }
}
