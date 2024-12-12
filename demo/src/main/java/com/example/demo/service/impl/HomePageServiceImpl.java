package com.example.demo.service.impl;

import com.example.demo.dto.BestPlayerInLastGameDto;
import com.example.demo.dto.BestPlayerThisSeasonDto;
import com.example.demo.dto.LastGameDto;
import com.example.demo.models.Game;
import com.example.demo.models.Performance;
import com.example.demo.models.Team;
import com.example.demo.repository.HomePageRepository;
import com.example.demo.service.HomePageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomePageServiceImpl implements HomePageService {
    private final HomePageRepository homePageRepository;

    @Autowired
    public HomePageServiceImpl(HomePageRepository homePageRepository) {
        this.homePageRepository = homePageRepository;
    }

    @Override
    public List<LastGameDto> getLastFourGames() {
        List<Game> games = this.homePageRepository.findLastFourGames();

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
        List<Performance> performances = this.homePageRepository.findTopPerformancesForEachGame();

        return performances.stream()
                .map(performance -> new BestPlayerInLastGameDto(
                        performance.getPlayer().getFullName(),
                        performance.getPoints(),
                        performance.getPasses(),
                        performance.getBlocks()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public BestPlayerThisSeasonDto getBestPlayerThisSeason() {
        Object[] stat = this.homePageRepository.findBestPlayerThisSeason();

        String fullName = (String) stat[0];
        Double avgPoints = (Double) stat[1];
        Double avgPasses = (Double) stat[2];
        Double avgBlocks = (Double) stat[3];
        String teamName = (String) stat[4];

        return new BestPlayerThisSeasonDto(fullName, avgPoints, avgPasses, avgBlocks, teamName);
    }
}
