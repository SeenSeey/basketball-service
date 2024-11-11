package com.example.demo.service;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.api.AddContractDto;

import java.util.List;

public interface ContractService {
    List<ContractDto> findContractByPlayerId(int id);
    void addContract(AddContractDto contractDto);
}
