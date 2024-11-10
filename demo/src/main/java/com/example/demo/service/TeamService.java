package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.dto.api.AddTeamDto;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamDto> findTeamByGameId(int id);
    TeamDto add(AddTeamDto addTeamDto);
    Optional<TeamDto> update(TeamDto updateDto);
}
