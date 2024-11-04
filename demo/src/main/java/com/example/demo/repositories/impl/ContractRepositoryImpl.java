package com.example.demo.repositories.impl;

import com.example.demo.models.Contract;
import com.example.demo.repositories.ContractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

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
    public List<Contract> findContractByPlayerId(String id) {
        return contractRepository.findContractByPlayerId(id);
    }
}
