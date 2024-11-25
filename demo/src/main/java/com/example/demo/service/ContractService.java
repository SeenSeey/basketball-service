package com.example.demo.service;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddContractDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContractService {
    List<ContractDto> findContractByPlayerId(int id);
    void addContract(AddContractDto contractDto);
    Page<ContractDto> getContracts(String search, int page, int size);
    ContractDto getContract(int id);
}
