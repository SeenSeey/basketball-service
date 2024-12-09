package com.example.basketball_contracts.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/best")
public interface BestPlayersController extends BaseController {

    //    Отображает кастомную страницу с пятью лучшими игроками сезона
    @GetMapping()
    String getPlayers(Model model);
}
