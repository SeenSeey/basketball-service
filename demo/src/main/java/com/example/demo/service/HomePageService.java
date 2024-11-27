package com.example.demo.service;

import com.example.demo.dto.BestPlayerInLastGameDto;
import com.example.demo.dto.LastGameDto;

import java.util.List;

public interface HomePageService {
    List<LastGameDto>  getLastFourGames();
    List<BestPlayerInLastGameDto> getTopPlayerForEachGame();

}
