package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.BestPlayersController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.bestPlayers.BestPlayerListViewModel;
import com.example.basketball_contracts.viewmodel.homePage.BestPlayerViewModel;
import com.example.demo.service.BestPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/best")
public class BestPlayersControllerImpl implements BestPlayersController {
    private final BestPlayersService playersService;

    @Autowired
    public BestPlayersControllerImpl(BestPlayersService playersService) {
        this.playersService = playersService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String getPlayers(Model model) {
        var players = playersService.getBestPlayersThisSeason();
        var playerViewModels = players.stream()
                .map(p -> new BestPlayerViewModel(
                        p.getFullName(),
                        p.getAvgPoints(),
                        p.getAvgPasses(),
                        p.getAvgBlocks(),
                        p.getTeamName()
                        )
                ).toList();

        var viewModel = new BestPlayerListViewModel(
                createBaseViewModel("Лучшие игроки сезона"),
                playerViewModels
        );

        model.addAttribute("model", viewModel);
        return "best-players";
    }
}
