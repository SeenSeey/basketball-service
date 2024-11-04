package com.example.demo.repositories;

import com.example.demo.models.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    @Query(value = "SELECT t FROM Team t JOIN t.contract c JOIN c.player p WHERE p.full_name = :playerFullName")
    Optional<Team> findTeamByPlayerFullName(@Param("playerFullName") String fullName);

    @Query(value = "SELECT t FROM Team t JOIN t.game g WHERE g.id = :gameId")
    List<Team> findTeamByGameId(@Param("gameId") String id);

    @Query(value = "SELECT a FROM Actor a WHERE a.id = :id")
    Optional<Team> findById(@Param("id") String id);
}
