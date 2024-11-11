package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.dto.api.AddTeamDto;
import com.example.demo.models.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamDto> findTeamByGameId(int id);
    void addTeam(AddTeamDto addTeamDto);
    Optional<TeamDto> updateTeam(TeamDto updateDto);
    Team findByName(String name);
}
