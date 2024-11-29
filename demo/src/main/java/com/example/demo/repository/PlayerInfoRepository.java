package com.example.demo.repository;

import com.example.demo.models.Player;

import java.util.List;

public interface PlayerInfoRepository {
    Object[] avgPerformanceAllTime(int playerId);
    List<String> teamsPlayed(int playerId);
    List<Player> findByNameContaining(String searchTerm);
    Object[] findBestGameForPlayers(int playerId);
}
