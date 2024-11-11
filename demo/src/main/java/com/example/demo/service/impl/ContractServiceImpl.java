package com.example.demo.service.impl;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.api.AddContractDto;
import com.example.demo.models.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.contractRepository = contractRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addContract(AddContractDto contractDto) {

        if (!this.validationUtil.isValid(contractDto)) {

            this.validationUtil
                    .violations(contractDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);

            throw new IllegalArgumentException("Illegal arguments!");
        }

        Contract contract = this.modelMapper.map(contractDto, Contract.class);

//        связь с Player and Team
    }

    @Override
    public List<ContractDto> findContractByPlayerId(int id) {
        return null;
    }
}
