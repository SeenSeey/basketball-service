package com.example.demo.repository;

import com.example.demo.models.Game;
import com.example.demo.models.Performance;

import java.util.List;

public interface HomePageRepository {
    List<Game> findLastFourGames();
    List<Performance> findTopPerformancesForEachGame();

}
