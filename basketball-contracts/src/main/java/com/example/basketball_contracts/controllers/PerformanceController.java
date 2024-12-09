package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.performance.PerformanceCreateForm;
import com.example.basketball_contracts.viewmodel.performance.PerformanceEditForm;
import com.example.basketball_contracts.viewmodel.performance.PerformanceSearchForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/performances")
public interface PerformanceController extends BaseController {

    @GetMapping
    String listPerformances(
            @ModelAttribute("form") PerformanceSearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createPerformanceForm(Model model);

    @PostMapping("/create")
    String createPerformance(
            @Valid @ModelAttribute("form") PerformanceCreateForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/edit/{id}")
    String editPerformanceForm(@PathVariable int id, Model model);

    @PostMapping("/edit/{id}")
    String editPerformance(
            @PathVariable int id,
            @Valid @ModelAttribute("form") PerformanceEditForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/{id}")
    String performanceDetails(@PathVariable int id, Model model);
}