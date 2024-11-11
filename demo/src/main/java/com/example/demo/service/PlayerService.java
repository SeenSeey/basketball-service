package com.example.demo.service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddPlayerDto;
import com.example.demo.models.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDto> findPlayerByTeamName(String name);
    void addPlayer(AddPlayerDto addPlayerDto);
    Optional<PlayerDto> updatePlayer(PlayerDto updatePlayerDto);

    Player findByName(String fullName);
}
