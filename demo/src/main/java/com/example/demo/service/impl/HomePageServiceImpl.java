package com.example.demo.service.impl;

import com.example.demo.dto.BestPlayerInLastGameDto;
import com.example.demo.dto.LastGameDto;
import com.example.demo.models.Game;
import com.example.demo.models.Performance;
import com.example.demo.models.Team;
import com.example.demo.repository.HomePageRepository;
import com.example.demo.service.HomePageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageServiceImpl implements HomePageService {
    private final HomePageRepository homePageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HomePageServiceImpl(HomePageRepository homePageRepository, ModelMapper modelMapper) {
        this.homePageRepository = homePageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LastGameDto> getLastFourGames() {
        List<Game> games = homePageRepository.findLastFourGames();

        return games.stream()
                .map(game -> {
                    String teamNameHome = game.getTeam().stream()
                            .findFirst()
                            .map(Team::getName)
                            .orElse("Команда не существует");

                    String teamNameVisit = game.getTeam().stream()
                            .skip(1)
                            .findFirst()
                            .map(Team::getName)
                            .orElse("Команда не существует");

                    return new LastGameDto(
                            teamNameHome,
                            game.getScoreHomeTeam(),
                            game.getDateOfGame(),
                            game.getScoreVisitorTeam(),
                            teamNameVisit
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<BestPlayerInLastGameDto> getTopPlayerForEachGame() {
        List<Performance> performances = homePageRepository.findTopPerformancesForEachGame();

        return performances.stream()
                .map(performance -> new BestPlayerInLastGameDto(
                        performance.getPlayer().getFullName(),
                        performance.getPoints(),
                        performance.getPasses(),
                        performance.getBlocks()
                ))
                .collect(Collectors.toList());
    }
}
