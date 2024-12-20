package com.example.demo.repository;

import com.example.demo.models.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query(value = "SELECT g FROM Game g JOIN g.team t WHERE t.name = :teamName")
    List<Game> findGameByTeamName(@Param("teamName") String name);

    @Query(value = "SELECT g FROM Game g JOIN g.performance per JOIN per.player pl WHERE pl.fullName = :playerFullName")
    List<Game> findGameByPlayerFullName(@Param("playerFullName") String fullName);

    @Query(value = "SELECT g FROM Game g WHERE g.id = :id")
    Optional<Game> findById(@Param("id") int id);

    @Query(value = "SELECT g FROM Game g")
    Page<Game> findAll(Pageable pageable);
}
