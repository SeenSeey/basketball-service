package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.GameController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.game.*;
import com.example.demo.dto.GameDto;
import com.example.demo.dto.api.AddGameDto;
import com.example.demo.service.GameService;
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
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/games")
public class GameControllerImpl implements GameController {
    private final GameService gameService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return  new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String listGames(@ModelAttribute("form") GameSearchForm form, Model model, Principal principal) {
        var page = form.page() != null ? form.page() : 1;
        var size = form.size() != null ? form.size() : 3;
        form = new GameSearchForm(page, size);

        var gamesPage = gameService.getGames(page, size);
        var gameViewModels = gamesPage.stream()
                .map(g -> new GameViewModel(
                        g.getId(),
                        g.getTeamNameHome(),
                        g.getTeamNameVisit(),
                        g.getScoreHomeTeam(),
                        g.getScoreVisitorTeam(),
                        g.getStadiumName(),
                        g.getDateOfGame()
                )).toList();

        var viewModel = new GameListViewModel(
                createBaseViewModel("Список игр"),
                gameViewModels,
                gamesPage.getTotalPages()
        );

        LOG.log(Level.INFO, "Show list of Games for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "game-list";
    }

    @Override
    @GetMapping("/create")
    public String createGameForm(Model model, Principal principal) {
        var viewModel = new GameCreateViewModel(
                createBaseViewModel("Создание игры")
        );

        LOG.log(Level.INFO, "Show Game Create Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new GameCreateForm("", "", 0, 0, "", LocalDate.now()));
        return "game-create";
    }

    
    @Override
    @PostMapping("/create")
    public String createGame(@Valid @ModelAttribute("form") GameCreateForm form,
                             BindingResult bindingResult,
                             Model model,
                             Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new GameCreateViewModel(
                    createBaseViewModel("Создание игры")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "game-create";
        }

        AddGameDto dto = new AddGameDto(
                form.homeTeam(),
                form.visitTeam(),
                form.scoreHomeTeam(),
                form.scoreVisitTeam(),
                form.stadiumName(),
                form.dateOfGame()
        );

        var id = gameService.addGame(dto);

        LOG.log(Level.INFO, "Create new Game by " + principal.getName());

        return "redirect:/games/" + id;
    }

    @Override
    @GetMapping("/edit/{id}")
    public String editGameForm(int id, Model model, Principal principal) {
        var game = gameService.getGame(id);
        var viewModel = new GameEditViewModel(
                createBaseViewModel("Редактирование игры")
        );

        LOG.log(Level.INFO, "Show Edit Game Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new GameEditForm(
                game.getId(),
                game.getTeamNameHome(),
                game.getTeamNameVisit(),
                game.getScoreHomeTeam(),
                game.getScoreVisitorTeam(),
                game.getStadiumName(),
                game.getDateOfGame()
        ));

        return "game-edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String editGame(@PathVariable int id,
                           @Valid @ModelAttribute("form") GameEditForm form,
                           BindingResult bindingResult,
                           Model model,
                           Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new GameEditViewModel(
                    createBaseViewModel("Редактироование игры")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "game-edit";
        }

        GameDto dto = new GameDto(
                form.id(),
                form.homeTeam(),
                form.visitTeam(),
                form.scoreHomeTeam(),
                form.scoreVisitTeam(),
                form.stadiumName(),
                form.dateOfGame()
        );
        gameService.updateGame(dto);

        LOG.log(Level.INFO, "Edit Game by " + principal.getName());

        return "redirect:/games/" + form.id();
    }

    @Override
    @GetMapping("/{id}")
    public String gameDetails(@PathVariable int id, Model model, Principal principal) {
        var game = gameService.getGame(id);
        var viewModel = new GameDetailsViewModel(
                createBaseViewModel("Книга"),
                new GameViewModel(
                        game.getId(),
                        game.getTeamNameHome(),
                        game.getTeamNameVisit(),
                        game.getScoreHomeTeam(),
                        game.getScoreVisitorTeam(),
                        game.getStadiumName(),
                        game.getDateOfGame()
                )
        );

        LOG.log(Level.INFO, "Show Game Details for " + principal.getName());

        model.addAttribute("model", viewModel);
        return "game-details";
    }
}
