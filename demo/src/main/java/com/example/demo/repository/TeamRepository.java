package com.example.demo.repository;

import com.example.demo.models.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    @Query(value = "SELECT t FROM Team t JOIN t.contract c JOIN c.player p WHERE p.fullName = :playerFullName")
    Optional<Team> findTeamByPlayerFullName(@Param("playerFullName") String fullName);

    @Query(value = "SELECT t FROM Team t JOIN t.game g WHERE g.id = :gameId")
    List<Team> findTeamByGameId(@Param("gameId") int id);

    @Query(value = "SELECT t FROM Team t WHERE t.name = :teamName")
    Optional<Team> findByName(@Param("teamName") String name);

    @Query(value = "SELECT t FROM Team t WHERE t.id = :id")
    Optional<Team> findById(@Param("id") int id);

    @Query(value = "SELECT t FROM Team t")
    Page<Team> findAll(Pageable pageable);

    @Query(value = "SELECT t FROM Team t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Team> findByTitleContainingIgnoreCase(@Param("searchTerm") String searchTerm, Pageable pageable);
}
