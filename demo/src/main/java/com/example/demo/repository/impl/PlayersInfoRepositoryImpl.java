package com.example.demo.repository.impl;

import com.example.demo.models.Player;
import com.example.demo.repository.PlayerInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class PlayersInfoRepositoryImpl implements PlayerInfoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findByNameContaining(String searchTerm) {
        String query = "SELECT p FROM Player p WHERE p.fullName LIKE :searchTerm";

        return entityManager.createQuery(query, Player.class)
                .setParameter("searchQuery", "%" + searchTerm + "%")
                .getResultList();
    }

    @Override
    public Object[] avgPerformanceAllTime(int playerId) {
        String query = "SELECT " +
                "AVG(perf.points) AS avgPoints, AVG(perf.passes) AS avgPasses, AVG(perf.blocks) AS avgBlocks " +
                "FROM Performance perf " +
                "JOIN perf.player p " +
                "WHERE p.id = :playerId " +
                "GROUP BY p.id";

        return (Object[]) entityManager.createQuery(query).setParameter("playerId", playerId).getSingleResult();
    }

    @Override
    public List<String> teamsPlayed(int playerId) {

        String query = "SELECT DISTINCT t.name " +
                "FROM Contract c " +
                "JOIN c.team t " +
                "WHERE c.player.id = :playerId";

        return entityManager.createQuery(query, String.class)
                .setParameter("playerId", playerId)
                .getResultList();
    }

    @Override
    public Object[] findBestGameForPlayers(int playerId) {

            String query = "SELECT perf.points, perf.passes, perf.blocks, g.dateOfGame " +
                    "FROM Performance perf " +
                    "JOIN perf.game g " +
                    "JOIN perf.player p " +
                    "WHERE p.id = :playerId " +
                    "ORDER BY perf.points DESC, perf.passes DESC, perf.blocks DESC " +
                    "LIMIT 1";

        return (Object[]) entityManager.createQuery(query)
                .setParameter("playerId", playerId)
                .setMaxResults(1)
                .getSingleResult();
    }
}
