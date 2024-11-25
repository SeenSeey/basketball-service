package com.example.demo.repository.impl;

import com.example.demo.models.Contract;
import com.example.demo.repository.ContractRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
