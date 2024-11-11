package com.example.demo.service.impl;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;
import com.example.demo.models.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addGame(AddGameDto gameDto) {

        if (!this.validationUtil.isValid(gameDto)) {

            this.validationUtil
                    .violations(gameDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Game game = this.modelMapper.map(gameDto, Game.class);
        this.gameRepository.save(game);
    }

    @Override
    public List<GameDto> findGameByTeamName(String name) {
        return null;
    }

    @Override
    public Optional<GameDto> updateGame(GameDto updateGameDto) {
        return Optional.empty();
    }

    @Override
    public Game findById(int id) {
        return this.gameRepository.findById(id).orElse(null);
    }
}
