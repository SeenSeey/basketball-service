package com.example.demo.repository;

import com.example.demo.models.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Query(value = "SELECT p FROM Player p JOIN p.contract c JOIN c.team t WHERE t.name = :teamName")
    List<Player> findPlayerByTeamName(@Param("teamName") String name);

    @Query(value = "SELECT p FROM Player p JOIN p.performance per JOIN per.game g WHERE g.id = :gameId")
    List<Player> findPlayerByGameId(@Param("gameId") int id);

    @Query(value = "SELECT p FROM Player p WHERE p.fullName = :playerFullName")
    Optional<Player> findByName(@Param("playerFullName") String fullName);

    @Query(value = "SELECT p FROM Player p WHERE p.id = :id")
    Optional<Player> findById(@Param("id") int id);

    @Query(value = "SELECT p FROM Player p")
    Page<Player> findAll(Pageable pageable);

    @Query(value = "SELECT p FROM Player p WHERE LOWER(p.fullName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Player> findByFullNameContainingIgnoreCase(@Param("searchTerm") String searchTerm, Pageable pageable);
}
