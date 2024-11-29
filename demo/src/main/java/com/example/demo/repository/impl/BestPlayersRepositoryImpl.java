package com.example.demo.repository.impl;

import com.example.demo.repository.BestPlayersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BestPlayersRepositoryImpl implements BestPlayersRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Object[]> findBestPlayersThisSeason() {
        String query = "SELECT p.fullName, " +
                "AVG(perf.points) AS avgPoints, AVG(perf.passes) AS avgPasses, AVG(perf.blocks) AS avgBlocks, " +
                "t.name AS teamName " +
                "FROM Performance perf " +
                "JOIN perf.game g " +
                "JOIN perf.player p " +
                "JOIN p.contracts c " +
                "JOIN c.team t " +
                "WHERE YEAR(g.dateOfGame) = YEAR(CURRENT_DATE) " +
                "AND c.contractStartDate <= CURRENT_DATE " +
                "AND c.contractEndDate >= CURRENT_DATE " +
                "GROUP BY p.id, t.name " +
                "ORDER BY avgPoints DESC";

        return entityManager.createQuery(query).setMaxResults(5).getResultList();
    }
}
