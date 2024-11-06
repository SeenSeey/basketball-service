package com.example.demo.repositories.impl;

import com.example.demo.models.Contract;
import com.example.demo.repositories.ContractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private ContractRepository contractRepository;

    @Override
    public Contract save(Contract contract) {
        entityManager.persist(contract);
        return contract;
    }

    @Override
    public List<Contract> findContractByPlayerId(int id) {
        return contractRepository.findContractByPlayerId(id);
    }
}
