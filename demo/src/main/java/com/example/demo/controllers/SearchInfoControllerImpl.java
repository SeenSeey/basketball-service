package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.SearchInfoController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoSearchForm;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoSearchViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.SearchPlayerInfoViewModel;
import com.example.demo.service.PlayersInfoService;
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
@RequestMapping("/search")
public class SearchInfoControllerImpl implements SearchInfoController {
    private final PlayersInfoService infoService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public SearchInfoControllerImpl(PlayersInfoService infoService) {
        this.infoService = infoService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String searchForm(Model model, Principal principal) {
       var viewModel = new PlayerInfoSearchViewModel(
               createBaseViewModel("Найти информацию")
       );

        if (principal == null) {
            LOG.log(Level.INFO, "Show Player`s Search Form for unregistered user");
        } else {
            LOG.log(Level.INFO, "Show Player`s Search Form for " + principal.getName());
        }

       model.addAttribute("model", viewModel);
       model.addAttribute("form", new PlayerInfoSearchForm(""));
       return "search-form";
    }

    @Override
    @PostMapping()
    public String search(@Valid @ModelAttribute("form") PlayerInfoSearchForm form,
                         BindingResult bindingResult,
                         Model model) {

       if (bindingResult.hasErrors()) {
           var viewModel = new PlayerInfoSearchViewModel(
                   createBaseViewModel("Найти информацию")
           );
           model.addAttribute("model", viewModel);
           model.addAttribute("form", form);
           return "search-form";
       }

       return "redirect:/search/" + form.fullName();
    }

    @GetMapping("/{name}")
    String getInfo(@PathVariable String name, Model model, Principal principal) {
        var playerInfo = infoService.getPlayersInfo(name);
        var playerInfoViewModels = playerInfo.stream()
                .map(p -> new SearchPlayerInfoViewModel(
                                p.getFullName(),
                                p.getAvgPoints(),
                                p.getAvgPasses(),
                                p.getAvgBlocks(),
                                p.getTeamNames(),
                                p.getMaxPoints(),
                                p.getMaxPasses(),
                                p.getMaxBlocks(),
                                p.getDateOfBestGame()
                        )
                ).toList();

        var viewModel = new PlayerInfoViewModel(
                createBaseViewModel("О игроке"),
                playerInfoViewModels,
                name
        );

        if (principal == null) {
            LOG.log(Level.INFO, "Show Player`s Info for unregistered user");
        } else {
            LOG.log(Level.INFO, "Show Player`s Info Form for " + principal.getName());
        }

        model.addAttribute("model", viewModel);
        return "player-info";
    }
}
