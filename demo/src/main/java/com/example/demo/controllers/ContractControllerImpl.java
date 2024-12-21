package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.ContractController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.contract.*;
import com.example.demo.dto.api.AddContractDto;
import com.example.demo.service.ContractService;
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
import java.time.LocalDate;

@Controller
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController {
    private final ContractService contractService;
    private static final Logger LOG = LogManager.getLogger(Controller.class);

    @Autowired
    public ContractControllerImpl(ContractService contractService) {
        this.contractService = contractService;
    }

    @Override
    public BaseViewModel createBaseViewModel(String title) {
        return new BaseViewModel(
                title
        );
    }

    @Override
    @GetMapping()
    public String listContracts(@ModelAttribute("form") ContractSearchForm form, Model model, Principal principal) {
        var page = form.page() != null ? form.page() : 1;
        var size = form.size() != null ? form.size() : 3;
        form = new ContractSearchForm(page, size);


        var contractsPage = contractService.getContracts(page, size);
        var contractViewModels = contractsPage.stream()
                .map(c -> new ContractViewModel(
                        c.getId(),
                        c.getPlayerId(),
                        c.getTeam(),
                        c.getSalaryPerYear(),
                        c.getContractStartDate(),
                        c.getContractEndDate()
                )).toList();

        var viewModel = new ContractListViewModel(
                createBaseViewModel("Список контрактов"),
                contractViewModels,
                contractsPage.getTotalPages()
        );

        LOG.log(Level.INFO, "Show list of Contracts for  " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "contract-list";
    }

    @Override
    @GetMapping("/create")
    public String createContractForm(Model model, Principal principal) {
        var viewModel = new ContractCreateViewModel(
                createBaseViewModel("Создание контракта")
        );

        LOG.log(Level.INFO, "Show Create Contract Form for " + principal.getName());

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new ContractCreateForm(0, "", 0, LocalDate.now(), LocalDate.now()));
        return "contract-create";
    }

    @Override
    @PostMapping("/create")
    public String createContract(@Valid @ModelAttribute("form") ContractCreateForm form,
                                 BindingResult bindingResult,
                                 Model model,
                                 Principal principal) {

        if (bindingResult.hasErrors()) {
            var viewModel = new ContractCreateViewModel(
                    createBaseViewModel("Создание контракта")
            );
            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "contract-create";
        }

        AddContractDto dto = new AddContractDto(
                form.playerId(),
                form.team(),
                form.salaryPerYear(),
                form.contractStartDate(),
                form.contractEndDate()
        );

        LOG.log(Level.INFO, "Create new Contract by " + principal.getName());

        var id = contractService.addContract(dto);
        return "redirect:/contracts/" + id;
    }

    @Override
    @GetMapping("/{id}")
    public String contractDetails(@PathVariable int id, Model model, Principal principal) {
        var contract = contractService.getContract(id);
        var viewModel = new ContractDetailsViewModel(
                createBaseViewModel("Контракт"),
                new ContractViewModel(
                        contract.getId(),
                        contract.getPlayerId(),
                        contract.getTeam(),
                        contract.getSalaryPerYear(),
                        contract.getContractStartDate(),
                        contract.getContractEndDate()
                )
        );

        LOG.log(Level.INFO, "Show Contract Details for " + principal.getName());

        model.addAttribute("model", viewModel);
        return "contract-details";
    }
}
