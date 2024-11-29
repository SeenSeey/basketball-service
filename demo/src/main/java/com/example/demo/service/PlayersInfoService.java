package com.example.demo.service;

import com.example.demo.dto.SearchPlayerInfoDto;

import java.util.List;

public interface PlayersInfoService {
    List<SearchPlayerInfoDto> getPlayersInfo(String searchTerm);
}
