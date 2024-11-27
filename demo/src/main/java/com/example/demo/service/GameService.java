package com.example.demo.service;

import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;
import com.example.demo.models.Game;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameService {
//    List<GameDto> findGameByTeamName(String name);
    void addGame(AddGameDto addGameDto);
    void updateGame(GameDto updateGameDto);
    Page<GameDto> getGames(int page, int size);
    GameDto getGame(int id);
    Game findById(int id);
}
