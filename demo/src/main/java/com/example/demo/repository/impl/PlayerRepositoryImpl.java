package com.example.demo.repository.impl;

import com.example.demo.models.Player;
import com.example.demo.repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Player update(Player player) {
        return entityManager.merge(player);
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
    public Optional<Player> findByName(String fullName) {
        return playerRepository.findByName(fullName);
    }

    @Override
    public Optional<Player> findById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public Page<Player> findAll(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @Override
    public Page<Player> findByFullNameContainingIgnoreCase(String searchTerm, Pageable pageable) {
        return playerRepository.findByFullNameContainingIgnoreCase(searchTerm, pageable);
    }
}
