package com.example.demo.repository.impl;

import com.example.demo.models.Game;
import com.example.demo.models.Performance;
import com.example.demo.repository.HomePageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomePageRepositoryImpl implements HomePageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Game> findLastFourGames() {
        return entityManager.createQuery(
                        "SELECT g FROM Game g ORDER BY g.dateOfGame DESC", Game.class)
                .setMaxResults(4)
                .getResultList();
    }

    @Override
    public List<Performance> findTopPerformancesForEachGame() {
        List<Game> lastFourGames = findLastFourGames();
        List<Performance> topPerformances = new ArrayList<>();

        for (Game game : lastFourGames) {
            Performance performance = entityManager.createQuery(
                            "SELECT p FROM Performance p WHERE p.game = :game ORDER BY p.points DESC", Performance.class)
                    .setParameter("game", game)
                    .setMaxResults(1)
                    .getSingleResult();

            topPerformances.add(performance);
        }

        return topPerformances;
    }
}
