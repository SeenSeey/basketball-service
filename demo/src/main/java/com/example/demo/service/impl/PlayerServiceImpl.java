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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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
    public void updatePlayer(PlayerDto updatePlayerDto) {

        if (!this.validationUtil.isValid(updatePlayerDto)) {

            this.validationUtil
                    .violations(updatePlayerDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        var player = this.playerRepository.findById(updatePlayerDto.getId())
                .orElseThrow(() -> new RuntimeException("Игрок не найден"));

        player.setFullName(updatePlayerDto.getFullName());
        player.setHeight(updatePlayerDto.getCountry());
        player.setCountry(updatePlayerDto.getCountry());
        player.setAge(updatePlayerDto.getAge());

        this.playerRepository.update(player);
    }

    @Override
    public Page<PlayerDto> getPlayers(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("title"));
        Page<Player> playerPage = search != null
                ? playerRepository.findByFullNameContainingIgnoreCase(search, pageable)
                : playerRepository.findAll(pageable);

        return playerPage.map(player -> new PlayerDto(
                player.getId(),
                player.getFullName(),
                player.getHeight(),
                player.getCountry(),
                player.getAge()
        ));
    }

    @Override
    public PlayerDto getPlayer(int id) {
        Player player = this.playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Игрок не найден"));

        return this.modelMapper.map(player, PlayerDto.class);
    }

    @Override
    public List<PlayerDto> findPlayerByTeamName(String name) {
        return null;
    }

    @Override
    public Player findById(int id) {
        return this.playerRepository.findById(id).orElse(null);
    }
}
