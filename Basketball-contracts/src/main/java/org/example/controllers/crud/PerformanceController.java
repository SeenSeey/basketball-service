package org.example.controllers.crud;

import jakarta.validation.Valid;
import org.example.controllers.base.BaseController;
import org.example.input.PerformanceCreateForm;
import org.example.input.PerformanceEditForm;
import org.example.viewmodel.base.SearchForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/performances")
public interface PerformanceController extends BaseController {

    @GetMapping
    String listPerformances(
            @ModelAttribute("form") SearchForm searchForm,
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
}
