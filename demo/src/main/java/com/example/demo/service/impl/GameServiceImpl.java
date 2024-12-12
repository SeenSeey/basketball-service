package com.example.demo.service.impl;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;
import com.example.demo.models.Game;
import com.example.demo.models.Team;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import com.example.demo.service.TeamService;
import com.example.demo.utils.validation.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TeamService teamService;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ValidationUtil validationUtil, ModelMapper modelMapper, TeamService teamService) {
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.teamService = teamService;
    }

    @Override
    public int addGame(AddGameDto gameDto) {

        if (!this.validationUtil.isValid(gameDto)) {

            this.validationUtil
                    .violations(gameDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Некорректные данные игры.");
        }

        Game game = this.modelMapper.map(gameDto, Game.class);

        Team homeTeam = this.teamService.findByName(gameDto.getTeamNameHome());
        Team visitTeam = this.teamService.findByName(gameDto.getTeamNameVisit());
        if (homeTeam == null || visitTeam == null) {
            throw new IllegalArgumentException("Одна или обе команды не найдены");
        }
        game.setTeam(Set.of(homeTeam, visitTeam));

        return this.gameRepository.save(game).getId();
    }


    @Override
    public void updateGame(GameDto updateGameDto) {

        if (!this.validationUtil.isValid(updateGameDto)) {

            this.validationUtil
                    .violations(updateGameDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        var game = this.gameRepository.findById(updateGameDto.getId())
                .orElseThrow(() -> new RuntimeException("Игра не найдена"));

        game.setTeam(Set.of(
                this.teamService.findByName(updateGameDto.getTeamNameHome()),
                this.teamService.findByName(updateGameDto.getTeamNameVisit())
        ));
        game.setScoreHomeTeam(updateGameDto.getScoreHomeTeam());
        game.setScoreVisitorTeam(updateGameDto.getScoreVisitorTeam());
        game.setStadiumName(updateGameDto.getStadiumName());
        game.setDateOfGame(updateGameDto.getDateOfGame());

        this.gameRepository.update(game);
    }

    @Override
    public Page<GameDto> getGames(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc("dateOfGame")));
        Page<Game> gamePage = gameRepository.findAll(pageable);

        return gamePage.map(game -> {
            String teamNameHome = game.getTeam().stream()
                    .findFirst()
                    .map(Team::getName)
                    .orElse("Команда не существует");

            String teamNameVisit = game.getTeam().stream()
                    .skip(1)
                    .findFirst()
                    .map(Team::getName)
                    .orElse("Команда не существует");

            return new GameDto(
                    game.getId(),
                    teamNameHome,
                    teamNameVisit,
                    game.getScoreHomeTeam(),
                    game.getScoreVisitorTeam(),
                    game.getStadiumName(),
                    game.getDateOfGame()
            );
        });
    }

    @Override
    public GameDto getGame(int id) {
        Game game = this.gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Игра не найдена"));

        String teamNameHome = game.getTeam().stream()
                .findFirst()
                .map(Team::getName)
                .orElse("Команда не существует");

        String teamNameVisit = game.getTeam().stream()
                .skip(1)
                .findFirst()
                .map(Team::getName)
                .orElse("Команда не существует");

        GameDto gameDto = this.modelMapper.map(game, GameDto.class);
        gameDto.setTeamNameHome(teamNameHome);
        gameDto.setTeamNameVisit(teamNameVisit);

        return gameDto;
    }

    @Override
    public Game findById(int id) {
        return this.gameRepository.findById(id).orElse(null);
    }
}
