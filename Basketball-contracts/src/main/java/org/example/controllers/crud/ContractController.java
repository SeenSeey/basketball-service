package org.example.controllers.crud;

import jakarta.validation.Valid;
import org.example.controllers.base.BaseController;
import org.example.viewmodel.contract.ContractCreateForm;
import org.example.viewmodel.contract.ContractSearchForm;
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
