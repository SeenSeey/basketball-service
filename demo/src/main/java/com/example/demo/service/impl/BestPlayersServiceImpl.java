package com.example.demo.service.impl;

import com.example.demo.dto.BestPlayerThisSeasonDto;
import com.example.demo.repository.BestPlayersRepository;
import com.example.demo.service.BestPlayersService;

import java.util.List;
import java.util.stream.Collectors;

public class BestPlayersServiceImpl implements BestPlayersService {
    private final BestPlayersRepository bestPlayersRepository;

    public BestPlayersServiceImpl(BestPlayersRepository bestPlayersRepository) {
        this.bestPlayersRepository = bestPlayersRepository;
    }

    @Override
    public List<BestPlayerThisSeasonDto> getBestPlayersThisSeason() {
        List<Object[]> stat = bestPlayersRepository.findBestPlayersThisSeason();

        return stat.stream().map(player -> new BestPlayerThisSeasonDto(
                (String) player[0],
                (Double) player[1],
                (Double) player[2],
                (Double) player[3],
                (String) player[4]
        )).collect(Collectors.toList());
    }
}
