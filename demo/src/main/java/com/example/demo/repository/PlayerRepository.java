package com.example.demo.repository;

import com.example.demo.models.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query(value = "SELECT p FROM Player p JOIN p.contract c JOIN c.team t WHERE t.name = :teamName")
    List<Player> findPlayerByTeamName(@Param("teamName") String name);

    @Query(value = "SELECT p FROM Player p JOIN p.performance per JOIN per.game g WHERE g.id = :gameId")
    List<Player> findPlayerByGameId(@Param("gameId") int id);

    @Query(value = "SELECT p FROM Player p WHERE p.id = :id")
    Optional<Player> findById(@Param("id") int id);
}
