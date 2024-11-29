package com.example.demo.service.impl;

import com.example.demo.dto.SearchPlayerInfoDto;
import com.example.demo.models.Player;
import com.example.demo.repository.PlayerInfoRepository;
import com.example.demo.service.PlayersInfoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayersInfoServiceImpl implements PlayersInfoService {
    private final PlayerInfoRepository playerInfoRepository;

    public PlayersInfoServiceImpl(PlayerInfoRepository playerInfoRepository) {
        this.playerInfoRepository = playerInfoRepository;
    }

    @Override
    public List<SearchPlayerInfoDto> getPlayersInfo(String searchTerm) {
        List<Player> players = playerInfoRepository.findByNameContaining(searchTerm);

        if (players.isEmpty()) {
            return new ArrayList<>();
        }

        List<SearchPlayerInfoDto> searchInfo = new ArrayList<>();

        for (Player player : players) {

            Object[] avgStat = playerInfoRepository.avgPerformanceAllTime(player.getId());
            Object[] bestStat = playerInfoRepository.findBestGameForPlayers(player.getId());
            List<String> teams = playerInfoRepository.teamsPlayed(player.getId());

            SearchPlayerInfoDto dto = new SearchPlayerInfoDto(
                    avgStat[0] != null ? (Double) avgStat[0] : 0.0,
                    avgStat[1] != null ? (Double) avgStat[1] : 0.0,
                    avgStat[2] != null ? (Double) avgStat[2] : 0.0,
                    teams,
                    bestStat[0] != null ? (Integer) bestStat[0] : 0,
                    bestStat[1] != null ? (Integer) bestStat[1] : 0,
                    bestStat[2] != null ? (Integer) bestStat[2] : 0,
                    (Date) bestStat[3]
            );

            searchInfo.add(dto);
        }

        return searchInfo;
    }
}
