package com.example.demo.service;

import com.example.demo.dto.BestPlayerThisSeasonDto;

import java.util.List;

public interface BestPlayersService {
    List<BestPlayerThisSeasonDto> getBestPlayersThisSeason();
}
