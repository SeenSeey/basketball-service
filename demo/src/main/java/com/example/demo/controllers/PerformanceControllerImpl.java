package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.PerformanceController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.performance.*;
import com.example.demo.dto.PerformanceDto;
import com.example.demo.dto.api.AddPerformanceDto;
import com.example.demo.service.PerformanceService;
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
@RequestMapping("/performances")
public class PerformanceControllerImpl implements PerformanceController {
    private final PerformanceService performanceService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public PerformanceControllerImpl(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(title);
    }

    @Override
    @GetMapping()
    public String listPerformances(@ModelAttribute("form") PerformanceSearchForm form, Model model, Principal principal) {
        var page = form.page() != null ? form.page() : 1;
        var size = form.size() != null ? form.size() : 3;
        form = new PerformanceSearchForm(page, size);

        var perfPage = performanceService.getPerformances(page, size);
        var perfViewModels = perfPage.stream()
                .map(p -> new PerformanceViewModel(
                        p.getId(),
                        p.getPlayerId(),
                        p.getGameId(),
                        p.getPoints(),
                        p.getBlocks(),
                        p.getPasses(),
                        p.getThreePointsShots()
                )).toList();

        var viewModel = new PerformanceListViewModel(
                createBaseViewModel("Список статистик"),
                perfViewModels,
                perfPage.getTotalPages()
        );

        LOG.log(Level.INFO, "Show list of Performances for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "performance-list";
    }

    @Override
    @GetMapping("/create")
    public String createPerformanceForm(Model model, Principal principal) {
        var viewModel = new PerformanceCreateViewModel(
                createBaseViewModel("Создание статистики")
        );

        LOG.log(Level.INFO, "Show Create Performance Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new PerformanceCreateForm(0, 0, 0, 0, 0, 0));
        return "performance-create";
    }

    @Override
    @PostMapping("/create")
    public String createPerformance(@Valid @ModelAttribute("form") PerformanceCreateForm form,
                                    BindingResult bindingResult,
                                    Model model,
                                    Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new PerformanceCreateViewModel(
                    createBaseViewModel("Создание статистики")
            );

            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "performance-create";
        }

        AddPerformanceDto dto = new AddPerformanceDto(
                form.playerId(),
                form.gameId(),
                form.points(),
                form.blocks(),
                form.passes(),
                form.threePointsShots()
        );

        var id = performanceService.addPerformance(dto);

        LOG.log(Level.INFO, "Create new Performance by " + principal.getName());

        return "redirect:/performances/" + id;
    }

    @Override
    @GetMapping("/edit/{id}")
    public String editPerformanceForm(int id, Model model, Principal principal) {
        var performance = performanceService.getPerformance(id);
        var viewModel = new PerformanceEditViewModel(
                createBaseViewModel("Редактирование статистики")
        );

        LOG.log(Level.INFO, "Show Edit Performance Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new PerformanceEditForm(
                performance.getId(),
                performance.getPlayerId(),
                performance.getGameId(),
                performance.getPoints(),
                performance.getBlocks(),
                performance.getPasses(),
                performance.getThreePointsShots()
        ));

        return "performance-edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String editPerformance(@PathVariable int id,
                                  @Valid @ModelAttribute("form") PerformanceEditForm form,
                                  BindingResult bindingResult,
                                  Model model,
                                  Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new PerformanceEditViewModel(
                    createBaseViewModel("Редактирование статистики")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "performance-edit";
        }

        PerformanceDto dto = new PerformanceDto(
                form.gameId(),
                form.playerId(),
                form.gameId(),
                form.points(),
                form.blocks(),
                form.passes(),
                form.threePointsShots()
        );

        performanceService.updatePerformance(dto);

        LOG.log(Level.INFO, "Edit Performance by " + principal.getName());

        return "redirect:/performances/" + form.id();
    }

    @Override
    @GetMapping("/{id}")
    public String performanceDetails(@PathVariable int id, Model model, Principal principal) {
        var perf = performanceService.getPerformance(id);
        var viewModel = new PerformanceDetailsViewModel(
                createBaseViewModel("Детали статистики"),
                new PerformanceViewModel(
                        perf.getId(),
                        perf.getPlayerId(),
                        perf.getGameId(),
                        perf.getPoints(),
                        perf.getBlocks(),
                        perf.getPasses(),
                        perf.getThreePointsShots()
                )
        );

        LOG.log(Level.INFO, "Show Performance details for " + principal.getName());

        model.addAttribute("model", viewModel);
        return "performance-details";
    }
}
