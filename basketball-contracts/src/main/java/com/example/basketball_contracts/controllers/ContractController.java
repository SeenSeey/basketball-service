package com.example.basketball_contracts.controllers;

import com.example.basketball_contracts.viewmodel.contract.ContractCreateForm;
import com.example.basketball_contracts.viewmodel.contract.ContractSearchForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/contracts")
public interface ContractController extends BaseController {

    @GetMapping
    String listContracts(
            @ModelAttribute("form") ContractSearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createContractForm(Model model);

    @PostMapping("/create")
    String createContract(
            @Valid @ModelAttribute("form") ContractCreateForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/{id}")
    String contractDetails(@PathVariable int id, Model model);
}