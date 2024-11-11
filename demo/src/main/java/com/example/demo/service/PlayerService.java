package com.example.demo.service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddPlayerDto;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDto> findPlayerByTeamName(String name);
    PlayerDto addPlayer(AddPlayerDto addPlayerDto);
    Optional<PlayerDto> updatePlayer(PlayerDto updatePlayerDto);
}
