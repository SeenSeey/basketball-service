package com.example.demo.repository.impl;

import com.example.demo.models.Performance;
import com.example.demo.repository.PerformanceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PerformanceRepositoryImpl implements PerformanceRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private PerformanceRepository performanceRepository;

    @Override
    public Performance save(Performance performance) {
        entityManager.persist(performance);
        return performance;
    }

    @Override
    public Optional<Performance> update(Performance performance) {
        return Optional.of(entityManager.merge(performance));
    }

    @Override
    public List<Performance> findPerformanceByPlayerFullName(String fullName) {
        return performanceRepository.findPerformanceByPlayerFullName(fullName);
    }

    @Override
    public Optional<Performance> findById(int id) {
        return performanceRepository.findById(id);
    }
}
