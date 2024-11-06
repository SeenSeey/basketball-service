package com.example.demo.repositories.impl;

import com.example.demo.models.Game;
import com.example.demo.repositories.GameRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepositoryImpl implements GameRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private GameRepository gameRepository;

    @Override
    public Game save(Game game) {
        entityManager.persist(game);
        return game;
    }

    @Override
    public Optional<Game> update(Game game) {
        return Optional.of(entityManager.merge(game));
    }

    @Override
    public List<Game> findGameByTeamName(String name) {
        return gameRepository.findGameByTeamName(name);
    }

    @Override
    public List<Game> findGameByPlayerFullName(String fullName) {
        return gameRepository.findGameByPlayerFullName(fullName);
    }

    @Override
    public Optional<Game> findById(int id) {
        return gameRepository.findById(id);
    }
}
