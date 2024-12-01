package com.example.demo.service;

import com.example.demo.dto.TeamDto;
import com.example.demo.dto.api.AddTeamDto;
import com.example.demo.models.Team;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TeamService {
//    List<TeamDto> findTeamByGameId(int id);
    int addTeam(AddTeamDto addTeamDto);
    void updateTeam(TeamDto updateDto);
    TeamDto getTeam(int id);
    Page<TeamDto> getTeams(String search, int page, int size);
    Team findByName(String name);
}
