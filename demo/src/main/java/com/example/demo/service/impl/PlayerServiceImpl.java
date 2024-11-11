package com.example.demo.service.impl;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddPlayerDto;
import com.example.demo.models.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addPlayer(AddPlayerDto playerDto) {

        if (!this.validationUtil.isValid(playerDto)) {

            this.validationUtil
                    .violations(playerDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Player player = this.modelMapper.map(playerDto, Player.class);
        this.playerRepository.save(player);
    }

    @Override
    public List<PlayerDto> findPlayerByTeamName(String name) {
        return null;
    }

    @Override
    public Optional<PlayerDto> updatePlayer(PlayerDto updatePlayerDto) {
        return Optional.empty();
    }

    @Override
    public Player findByName(String fullName) {
        return this.playerRepository.findByName(fullName).orElse(null);
    }
}
