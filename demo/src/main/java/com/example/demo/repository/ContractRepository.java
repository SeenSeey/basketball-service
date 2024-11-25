package com.example.demo.repository;

import com.example.demo.models.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends BaseRepository<Contract, Integer> {
    @Query(value = "SELECT c FROM Contract c JOIN c.player p WHERE p.id = :playerId")
    List<Contract> findContractByPlayerId(@Param("playerId") int id);

    @Query(value = "SELECT c FROM Contract c WHERE c.id = :id")
    Optional<Contract> findById(@Param("id") int id);
}
