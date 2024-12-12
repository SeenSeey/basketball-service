package com.example.demo.service.impl;

import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;
import com.example.demo.models.Performance;
import com.example.demo.repository.PerformanceRepository;
import com.example.demo.service.GameService;
import com.example.demo.service.PerformanceService;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.validation.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
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
    public int addPerformance(AddPerformanceDto performanceDto) {

        if (!this.validationUtil.isValid(performanceDto)) {

            this.validationUtil
                    .violations(performanceDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

        Performance performance = this.modelMapper.map(performanceDto, Performance.class);

        performance.setPlayer(this.playerService.findById(performanceDto.getPlayerId()));
        performance.setGame(this.gameService.findById(performanceDto.getGameId()));

        return this.performanceRepository.save(performance).getId();
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
    public Page<PerformanceDto> getPerformances(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id"));
        Page<Performance> performancePage = this.performanceRepository.findAll(pageable);

        return performancePage.map(performance -> new PerformanceDto(
                performance.getId(),
                performance.getPlayer().getId(),
                performance.getGame().getId(),
                performance.getPoints(),
                performance.getBlocks(),
                performance.getPasses(),
                performance.getThreePointsShots()
        ));
    }

    @Override
    public PerformanceDto getPerformance(int id) {
        Performance performance = this.performanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Статистика не найдена"));

        return this.modelMapper.map(performance, PerformanceDto.class);
    }

//    @Override
//    public List<PerformanceDto> findPerformanceByPlayerFullName(String fullName) {
//        return null;
//    }
//
//    @Override
//    public List<PerformanceDto> findPerformanceByNameAndDate(String fullName) {
//        return null;
//    }
}
