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
import org.springframework.data.domain.Page;

import java.util.List;

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

        performance.setPlayer(this.playerService.findById(performanceDto.getPlayerId()));
        performance.setGame(this.gameService.findById(performanceDto.getGameId()));

        this.performanceRepository.save(performance);
    }

    @Override
    public void updatePerformance(PerformanceDto updatePerformanceDto) {

        if (!this.validationUtil.isValid(updatePerformanceDto)) {

            this.validationUtil
                    .violations(updatePerformanceDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        var performance = performanceRepository.findById(updatePerformanceDto.getId())
                .orElseThrow(() -> new RuntimeException("Статистика не найдена"));

        performance.setPlayer(this.playerService.findById(updatePerformanceDto.getPlayerId()));
        performance.setGame(this.gameService.findById(updatePerformanceDto.getGameId()));
        performance.setPoints(updatePerformanceDto.getPoints());
        performance.setBlocks(updatePerformanceDto.getBlocks());
        performance.setPasses(updatePerformanceDto.getPasses());
        performance.setThreePointsShots(updatePerformanceDto.getThreePointsShots());

        this.performanceRepository.update(performance);
    }

    @Override
    public Page<PerformanceDto> getPerformances(String search, int page, int size) {
        return null;
    }

    @Override
    public PerformanceDto getPerformance(int id) {
        Performance performance = this.performanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Статистика не найдена"));

        return this.modelMapper.map(performance, PerformanceDto.class);
    }

    @Override
    public List<PerformanceDto> findPerformanceByPlayerFullName(String fullName) {
        return null;
    }

    @Override
    public List<PerformanceDto> findPerformanceByNameAndDate(String fullName) {
        return null;
    }
}
