package com.example.demo.service;

import com.example.demo.dto.ContractDto;

import java.util.List;

public interface ContractService {
    List<ContractDto> findContractByPlayerId(int id);
    ContractDto add(ContractDto ContractDto);
}
