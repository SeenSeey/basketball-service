package org.example.controllers.crud;

import jakarta.validation.Valid;
import org.example.controllers.base.BaseController;
import org.example.input.ContractCreateForm;
import org.example.viewmodel.base.SearchForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/contracts")
public interface ContractController extends BaseController {

    @GetMapping
    String listContracts(
            @ModelAttribute("form") SearchForm searchForm,
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
}
