package com.example.demo.service;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<GameDto> findGameByTeamName(String name);
    GameDto addGame(AddGameDto addGameDto);
    Optional<GameDto> updateGame(GameDto updateGameDto);
}
