package com.example.demo.service.impl;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.api.AddContractDto;
import com.example.demo.models.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import com.example.demo.service.PlayerService;
import com.example.demo.service.TeamService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PlayerService playerService;
    private final TeamService teamService;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, ValidationUtil validationUtil,
                               ModelMapper modelMapper, PlayerService playerService, TeamService teamService) {
        this.contractRepository = contractRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @Override
    public void addContract(AddContractDto contractDto) {

        if (!this.validationUtil.isValid(contractDto)) {

            this.validationUtil
                    .violations(contractDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Contract contract = this.modelMapper.map(contractDto, Contract.class);

        contract.setPlayer(this.playerService.findById(contractDto.getPlayerId()));
        contract.setTeam(this.teamService.findByName(contractDto.getTeam()));

        this.contractRepository.save(contract);
    }

    @Override
    public Page<ContractDto> getContracts(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id"));
        Page<Contract> contractPage = contractRepository.findAll(pageable);

        return contractPage.map(contract -> new ContractDto(
                contract.getId(),
                contract.getPlayer().getId(),
                contract.getTeam().getName(),
                contract.getSalaryPerYear(),
                contract.getContractStartDate(),
                contract.getContractEndDate()
        ));
    }

    @Override
    public ContractDto getContract(int id) {
        Contract contract = this.contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Контракт не найден"));

        return this.modelMapper.map(contract, ContractDto.class);
    }

    @Override
    public List<ContractDto> findContractByPlayerId(int id) {
        return null;
    }
}
