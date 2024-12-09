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

    @Override
    public Object[] findBestPlayerThisSeason() {
        String query = "SELECT p.fullName, " +
                "AVG(perf.points) AS avgPoints, AVG(perf.passes) AS avgPasses, AVG(perf.blocks) AS avgBlocks, " +
                "t.name AS teamName " +
                "FROM Performance perf " +
                "JOIN perf.game g " +
                "JOIN perf.player p " +
                "JOIN p.contract c " +
                "JOIN c.team t " +
                "WHERE YEAR(g.dateOfGame) = YEAR(CURRENT_DATE) " +
                "AND c.contractStartDate <= CURRENT_DATE " +
                "AND c.contractEndDate >= CURRENT_DATE " +
                "GROUP BY p.id, t.name " +
                "ORDER BY avgPoints DESC " +
                "LIMIT 1";

        return (Object[]) entityManager.createQuery(query).getSingleResult();
    }
}
