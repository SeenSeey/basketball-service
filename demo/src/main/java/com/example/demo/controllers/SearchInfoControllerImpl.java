package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.SearchInfoController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoSearchForm;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoSearchViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoViewModel;
import com.example.basketball_contracts.viewmodel.searchInfo.SearchPlayerInfoViewModel;
import com.example.demo.service.PlayersInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/search")
public class SearchInfoControllerImpl implements SearchInfoController {
   private final PlayersInfoService infoService;

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
    public String searchForm(Model model) {
       var viewModel = new PlayerInfoSearchViewModel(
               createBaseViewModel("Найти информацию")
       );

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
    String getInfo(@PathVariable String name, Model model) {
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

        model.addAttribute("model", viewModel);
        return "player-info";
    }
}
