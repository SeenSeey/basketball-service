package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.HomeController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.homePage.BestPlayerGameViewModel;
import com.example.basketball_contracts.viewmodel.homePage.BestPlayerViewModel;
import com.example.basketball_contracts.viewmodel.homePage.HomePageViewModel;
import com.example.basketball_contracts.viewmodel.homePage.LastGameViewModel;
import com.example.demo.service.HomePageService;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeControllerImpl implements HomeController {
    private final HomePageService homePageService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public HomeControllerImpl(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String homePage(Model model, Principal principal) {
        var games = homePageService.getLastFourGames();
        var gameViewModels = games.stream()
                .map(g -> new LastGameViewModel(
                        g.getTeamNameHome(),
                        g.getTeamNameVisit(),
                        g.getScoreHomeTeam(),
                        g.getScoreVisitorTeam(),
                        g.getDateOfGame()
                        )
                ).toList();

        var players = homePageService.getTopPlayerForEachGame();
        var playerViewModels = players.stream()
                .map(p -> new BestPlayerGameViewModel(
                        p.getFullName(),
                        p.getPoints(),
                        p.getPasses(),
                        p.getBlocks()
                        )
                ).toList();

        var bestPlayer = homePageService.getBestPlayerThisSeason();
        var bestPlayerViewModel = new BestPlayerViewModel(
                bestPlayer.getFullName(),
                bestPlayer.getAvgPoints(),
                bestPlayer.getAvgPasses(),
                bestPlayer.getAvgBlocks(),
                bestPlayer.getTeamName()
        );

        var viewModel = new HomePageViewModel(
                createBaseViewModel("BSKT BSKT BSKT"),
                gameViewModels,
                playerViewModels,
                bestPlayerViewModel
        );

        if (principal == null) {
            LOG.log(Level.INFO, "Show Home Page for unregistered user");
        } else {
            LOG.log(Level.INFO, "Show Home Page for " + principal.getName());
        }

        model.addAttribute("model", viewModel);
        return "home-page";
    }
}
