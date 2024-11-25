package org.example.controllers.crud;

import jakarta.validation.Valid;
import org.example.controllers.base.BaseController;
import org.example.input.TeamCreateForm;
import org.example.input.TeamEditForm;
import org.example.viewmodel.base.SearchForm;
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
}
