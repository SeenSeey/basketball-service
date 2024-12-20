package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.game.GameCreateForm;
import com.example.basketball_contracts.viewmodel.game.GameEditForm;
import com.example.basketball_contracts.viewmodel.game.GameSearchForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/games")
public interface GameController extends BaseController {

    @GetMapping
    String listGames(
            @ModelAttribute("form") GameSearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createGameForm(Model model);

    @PostMapping("/create")
    String createGame(
            @Valid @ModelAttribute("form") GameCreateForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/edit/{id}")
    String editGameForm(@PathVariable int id, Model model);

    @PostMapping("/edit/{id}")
    String editGame(
            @PathVariable int id,
            @Valid @ModelAttribute("form") GameEditForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/{id}")
    String gameDetails(@PathVariable int id, Model model);
}
