package com.example.basketball_contracts.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface HomeController extends BaseController {

    //    Отображает главную страницу
    @GetMapping()
    String homePage(Model model);
}
