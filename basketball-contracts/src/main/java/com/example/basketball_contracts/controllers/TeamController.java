package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.base.SearchForm;
import com.example.basketball_contracts.viewmodel.team.TeamCreateForm;
import com.example.basketball_contracts.viewmodel.team.TeamEditForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/teams")
public interface TeamController extends BaseController {

    @GetMapping
    String listTeams(
            @ModelAttribute("form") SearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createTeamForm(Model model);

    @PostMapping("/create")
    String createTeam(
            @Valid @ModelAttribute("form") TeamCreateForm form,
            BindingResult bindingResult,
            Model model
    );


    @GetMapping("/edit/{id}")
    String editTeamForm(@PathVariable int id, Model model);

    @PostMapping("/edit/{id}")
    String editTeam(
            @PathVariable int id,
            @Valid @ModelAttribute("form") TeamEditForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/{id}")
    String teamDetails(@PathVariable int id, Model model);
}