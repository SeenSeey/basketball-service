package com.example.demo.service.impl;

import com.example.demo.dto.TeamDto;
import com.example.demo.dto.api.AddTeamDto;
import com.example.demo.models.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.service.TeamService;
import com.example.demo.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addTeam(AddTeamDto teamDto) {

        if (!this.validationUtil.isValid(teamDto)) {

            this.validationUtil
                    .violations(teamDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        Team team = this.modelMapper.map(teamDto, Team.class);
        this.teamRepository.save(team);
    }

    @Override
    public void updateTeam(TeamDto updateDto) {

        if (!this.validationUtil.isValid(updateDto)) {

            this.validationUtil
                    .violations(updateDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        var team = this.teamRepository.findById(updateDto.getId())
                .orElseThrow(() -> new RuntimeException("Команда не найдена"));

        team.setName(updateDto.getName());
        team.setConference(updateDto.getConference());
        team.setWinsInSeason(updateDto.getWinsInSeason());
        team.setLoosesInSeason(updateDto.getLoosesInSeason());

        this.teamRepository.update(team);
    }

    @Override
    public List<TeamDto> findTeamByGameId(int id) {
        return null;
    }

    @Override
    public TeamDto getTeam(int id) {
        Team team = this.teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Команда не найдена"));

        return this.modelMapper.map(team, TeamDto.class);
    }

    @Override
    public Page<TeamDto> getTeams(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("name"));
        Page<Team> teamPage = search != null
                ? this.teamRepository.findByTitleContainingIgnoreCase(search, pageable)
                : this.teamRepository.findAll(pageable);

        return teamPage.map(team -> new TeamDto(
                team.getId(),
                team.getName(),
                team.getConference(),
                team.getWinsInSeason(),
                team.getLoosesInSeason()
        ));
    }

    @Override
    public Team findByName(String name) {
        return this.teamRepository.findByName(name).orElse(null);
    }
}
