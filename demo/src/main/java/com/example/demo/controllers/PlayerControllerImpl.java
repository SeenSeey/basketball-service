package com.example.demo.controllers;

import com.example.demo.dto.PlayerDto;
import com.example.demo.dto.api.AddPlayerDto;
import com.example.demo.service.PlayerService;
import jakarta.validation.Valid;
import org.example.controllers.crud.PlayerController;
import org.example.viewmodel.player.*;
import org.example.viewmodel.base.BaseViewModel;
import org.example.viewmodel.base.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerControllerImpl implements PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerControllerImpl(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String listPlayers(@ModelAttribute("form") SearchForm form, Model model) {
        var searchTerm = form.searchTerm() != null ? form.searchTerm() : "";
        var page = form.page() != null ? form.page() : 1;
        var size = form.size() != null ? form.size() : 3;
        form = new SearchForm(searchTerm, page, size);

        var playersPage = playerService.getPlayers(searchTerm, page, size);
        var playerViewModels = playersPage.stream()
                .map(p -> new PlayerViewModel(p.getId(), p.getFullName(), p.getAge(), p.getHeight(), p.getCountry()))
                .toList();

        var viewModel = new PlayerListViewModel(
                createBaseViewModel("Список игроков"),
                playerViewModels,
                playersPage.getTotalPages()
        );

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "player-list";
    }

    @Override
    @GetMapping("/create")
    public String createPlayerForm(Model model) {
        var viewModel = new PlayerCreateViewModel(
                createBaseViewModel("Создание игрока")
        );

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new PlayerCreateForm("", "", "", 17));
        return "player-create";
    }

    @Override
    @PostMapping("/create")
    public String createPlayer(@Valid @ModelAttribute("form") PlayerCreateForm form,
                               BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            var viewModel = new PlayerCreateViewModel(
                    createBaseViewModel("Создание игрока")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "player-create";
        }

        AddPlayerDto dto = new AddPlayerDto(form.fullName(), form.height(), form.country(), form.age());
        var id = playerService.addPlayer(dto);
        return "redirect:/players/" + id;
    }

    @Override
    @GetMapping("/edit/{id}")
    public String editPlayerForm(int id, Model model) {
        var player = playerService.getPlayer(id);
        var viewModel = new PlayerEditViewModel(
                createBaseViewModel("Редактирование игрока")
        );

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new PlayerEditForm(player.getId(), player.getFullName(), player.getAge(),
                player.getHeight(), player.getCountry()));
        return "player-edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String editPlayer(@PathVariable  int id,
                             @Valid @ModelAttribute("form") PlayerEditForm form,
                             BindingResult bindingResult,
                             Model model) {

        if (bindingResult.hasErrors()) {
            var viewModel = new PlayerEditViewModel(
                    createBaseViewModel("Редактироване игрока")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "player-edit";
        }

        PlayerDto dto = new PlayerDto(form.id(), form.fullName(), form.height(), form.country(), form.age());
        playerService.updatePlayer(dto);
        return "redirect:/players/" + form.id();
    }

    @Override
    @GetMapping("/{id}")
    public String playerDetails(@PathVariable int id, Model model) {
        var p = playerService.getPlayer(id);
        var viewModel = new PlayerDetailsViewModel(
                createBaseViewModel("Игрок"),
                new PlayerViewModel(p.getId(), p.getFullName(), p.getAge(), p.getHeight(), p.getCountry())
        );

        model.addAttribute("model", viewModel);
        return "player-details";
    }
}
