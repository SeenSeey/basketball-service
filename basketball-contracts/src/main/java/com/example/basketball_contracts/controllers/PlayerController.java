package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.base.SearchForm;
import com.example.basketball_contracts.viewmodel.player.PlayerCreateForm;
import com.example.basketball_contracts.viewmodel.player.PlayerEditForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/players")
public interface PlayerController extends BaseController {

    @GetMapping
    String listPlayers(
            @ModelAttribute("form") SearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createPlayerForm(Model model);

    @PostMapping("/create")
    String createPlayer(
            @Valid @ModelAttribute("form") PlayerCreateForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/edit/{id}")
    String editPlayerForm(@PathVariable int id, Model model);

    @PostMapping("/edit/{id}")
    String editPlayer(
            @PathVariable int id,
            @Valid @ModelAttribute("form") PlayerEditForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/{id}")
    String playerDetails(int id, Model model);
}