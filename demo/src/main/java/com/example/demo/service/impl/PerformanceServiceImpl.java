package com.example.demo.service.impl;

import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;
import com.example.demo.models.Performance;
import com.example.demo.repository.PerformanceRepository;
import com.example.demo.service.GameService;
import com.example.demo.service.PerformanceService;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceRepository performanceRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PlayerService playerService;
    private final GameService gameService;

    @Autowired
    public PerformanceServiceImpl(PerformanceRepository performanceRepository, ValidationUtil validationUtil,
                                  ModelMapper modelMapper, PlayerService playerService, GameService gameService) {
        this.performanceRepository = performanceRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @Override
    public void addPerformance(AddPerformanceDto performanceDto) {

        if (!this.validationUtil.isValid(performanceDto)) {

            this.validationUtil
                    .violations(performanceDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Performance performance = this.modelMapper.map(performanceDto, Performance.class);

        performance.setPlayer(this.playerService.findByName(performanceDto.getPlayer()));
        performance.setGame(this.gameService.findById(performanceDto.getGameId()));

        this.performanceRepository.save(performance);
    }

    @Override
    public List<PerformanceDto> findPerformanceByPlayerFullName(String fullName) {
        return null;
    }

    @Override
    public List<PerformanceDto> findPerformanceByNameAndDate(String fullName) {
        return null;
    }

    @Override
    public Optional<PerformanceDto> updatePerformance(PerformanceDto updatePerformanceDto) {
        return Optional.empty();
    }
}
