package com.example.demo.controllers;

import org.example.controllers.home.org.example.controllers.home.HomeController;
import org.example.viewmodel.base.BaseViewModel;
import org.example.viewmodel.homePage.HomePageViewModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeControllerImpl implements HomeController {
    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping("/")
    public String index(Model model) {
//        var viewModel = new HomePageViewModel(createBaseViewModel("Главная страница"));
//        model.addAttribute("model", viewModel);
        return null;
    }
}
