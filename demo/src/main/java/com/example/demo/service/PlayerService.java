package com.example.demo.service;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddPlayerDto;
import com.example.demo.models.Player;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
//    List<PlayerDto> findPlayerByTeamName(String name);
    int addPlayer(AddPlayerDto addPlayerDto);
    void updatePlayer(PlayerDto updatePlayerDto);
    Page<PlayerDto> getPlayers(String search, int page, int size);
    PlayerDto getPlayer(int id);
    Player findById(int id);
}
