package com.example.demo.controllers;

import com.example.basketball_contracts.controllers.ContractController;
import com.example.basketball_contracts.viewmodel.base.BaseViewModel;
import com.example.basketball_contracts.viewmodel.contract.*;
import com.example.demo.dto.api.AddContractDto;
import com.example.demo.service.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/contracts")
public class ContractControllerImpl implements ContractController {
    private final ContractService contractService;

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
    public String listContracts(@ModelAttribute("form") ContractSearchForm form, Model model) {
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

        model.addAttribute("model", viewModel);
        model.addAttribute("form", form);
        return "contract-list";
    }

    @Override
    @GetMapping("/create")
    public String createContractForm(Model model) {
        var viewModel = new ContractCreateViewModel(
                createBaseViewModel("Создание контракта")
        );
        model.addAttribute("model", viewModel);
        model.addAttribute("form", new ContractCreateForm(0, "", 0, LocalDate.now(), LocalDate.now()));
        return "contract-create";
    }

    @Override
    @PostMapping("/create")
    public String createContract(@Valid @ModelAttribute("form") ContractCreateForm form,
                                 BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            var viewModel = new ContractCreateViewModel(
                    createBaseViewModel("Сщздание контракта")
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
        var id = contractService.addContract(dto);
        return "redirect:/contracts/" + id;
    }

    @Override
    @GetMapping("/{id}")
    public String contractDetails(@PathVariable int id, Model model) {
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

        model.addAttribute("model", viewModel);
        return "contract-details";
    }
}
