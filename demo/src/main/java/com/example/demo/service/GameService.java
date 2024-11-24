package com.example.demo.service;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;
import com.example.demo.models.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<GameDto> findGameByTeamName(String name);
    void addGame(AddGameDto addGameDto);
    void updateGame(GameDto updateGameDto);
    Game findById(int id);
}
