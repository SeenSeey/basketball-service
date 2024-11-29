package com.example.demo.repository;

import java.util.List;

public interface BestPlayersRepository {
    List<Object[]> findBestPlayersThisSeason();
}
