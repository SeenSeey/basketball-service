package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.searchInfo.PlayerInfoSearchForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/search")
public interface SearchInfoController extends BaseController {

    //    Отображает информацию о игроке
    @GetMapping()
    String searchForm(Model model);


    @PostMapping()
    String search(@Valid @ModelAttribute("form") PlayerInfoSearchForm searchForm,
                  BindingResult bindingResult,
                  Model model);
}
