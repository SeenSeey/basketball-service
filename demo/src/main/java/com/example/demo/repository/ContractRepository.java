package com.example.demo.repository;

import com.example.demo.models.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRepository extends BaseRepository<Contract, Integer> {
    @Query(value = "SELECT c FROM Contract c JOIN c.player p WHERE p.id = :playerId")
    List<Contract> findContractByPlayerId(@Param("playerId") int id);
}