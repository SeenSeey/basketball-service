package com.example.demo.repositories.impl;

import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private PlayerRepository playerRepository;

    @Override
    public Player save(Player player) {
        entityManager.persist(player);
        return player;
    }

    @Override
    public Optional<Player> update(Player player) {
        return Optional.of(entityManager.merge(player));
    }

    @Override
    public List<Player> findPlayerByTeamName(String name) {
        return playerRepository.findPlayerByTeamName(name);
    }

    @Override
    public List<Player> findPlayerByGameId(int id) {
        return playerRepository.findPlayerByGameId(id);
    }

    @Override
    public Optional<Player> findById(int id) {
        return playerRepository.findById(id);
    }
}
