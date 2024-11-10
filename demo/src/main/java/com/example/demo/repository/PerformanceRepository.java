package com.example.demo.repository;

import com.example.demo.models.Performance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PerformanceRepository extends CrudRepository<Performance, Integer> {
    @Query(value = "SELECT p FROM Performance p JOIN p.player pl WHERE pl.fullName = :playerFullName")
    List<Performance> findPerformanceByPlayerFullName(@Param("playerFullName") String fullName);

    @Query(value = "SELECT p FROM Performance p WHERE p.id = :id")
    Optional<Performance> findById(@Param("id") int id);
}
