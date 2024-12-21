package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.TeamController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.base.SearchForm;
import com.example.basketball_contracts.viewmodel.team.*;
import com.example.demo.dto.TeamDto;
import com.example.demo.dto.api.AddTeamDto;
import com.example.demo.service.TeamService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/teams")
public class TeamControllerImpl implements TeamController {
    private final TeamService teamService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public TeamControllerImpl(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String listTeams(@ModelAttribute("form") SearchForm form, Model model, Principal principal) {
        var searchTerm = form.searchTerm() != null ? form.searchTerm() : "";
        var page = form.page() != null ? form.page() : 1;
        var size = form.size() != null ? form.size() : 3;
        form = new SearchForm(searchTerm, page, size);

        var teamsPage = teamService.getTeams(searchTerm, page, size);
        var teamViewModels = teamsPage.stream()
                .map(t -> new TeamViewModel(t.getId(), t.getName(), t.getConference(), t.getWinsInSeason(), t.getLoosesInSeason()))
                .toList();

        var viewModel = new TeamListViewModel(
                createBaseViewModel("Список команд"),
                teamViewModels,
                teamsPage.getTotalPages()
        );

        LOG.log(Level.INFO, "Show list of Teams for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "team-list";
    }

    @Override
    @GetMapping("/create")
    public String createTeamForm(Model model, Principal principal) {
        var viewModel = new TeamCreateViewModel(
                createBaseViewModel("Создание команды")
        );

        LOG.log(Level.INFO, "Show Create Team Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new TeamCreateForm("", "", 0, 0));
        return "team-create";
    }

    @Override
    @PostMapping("/create")
    public String createTeam(@Valid @ModelAttribute("form") TeamCreateForm form,
                             BindingResult bindingResult,
                             Model model,
                             Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new TeamCreateViewModel(
                    createBaseViewModel("Создание команды")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "team-create";
        }

        AddTeamDto dto = new AddTeamDto(form.name(), form.conference(), form.winsInSeason(), form.loosesInSeason());
        var id = teamService.addTeam(dto);

        LOG.log(Level.INFO, "Create new Team by " + principal.getName());

        return "redirect:/teams/" + id;
    }

    @Override
    @GetMapping("/edit/{id}")
    public String editTeamForm(int id, Model model, Principal principal) {
        var team = teamService.getTeam(id);
        var viewModel = new TeamEditViewModel(
                createBaseViewModel("Редактирование команды")
        );

        LOG.log(Level.INFO, "Show Edit Player Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new TeamEditForm(
                team.getId(),
                team.getName(),
                team.getConference(),
                team.getWinsInSeason(),
                team.getLoosesInSeason()
        ));

        return "team-edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String editTeam(@PathVariable int id,
                           @Valid @ModelAttribute TeamEditForm form,
                           BindingResult bindingResult,
                           Model model,
                           Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new TeamEditViewModel(
                    createBaseViewModel("Редактирование команды")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "team-edit";
        }

        TeamDto dto = new TeamDto(form.id(), form.name(), form.conference(), form.winsInSeason(), form.loosesInSeason());
        teamService.updateTeam(dto);

        LOG.log(Level.INFO, "Edit new Team by " + principal.getName());

        return "redirect:/teams/" + form.id();
    }

    @Override
    public String teamDetails(@PathVariable int id, Model model, Principal principal) {
        var team = teamService.getTeam(id);
        var viewModel = new TeamDetailsViewModel(
                createBaseViewModel("Книга"),
                new TeamViewModel(team.getId(), team.getName(), team.getConference(), team.getWinsInSeason(), team.getLoosesInSeason())
        );

        LOG.log(Level.INFO, "Show Player Details for " + principal.getName());

        model.addAttribute("model", viewModel);
        return "team-details";
    }
}
