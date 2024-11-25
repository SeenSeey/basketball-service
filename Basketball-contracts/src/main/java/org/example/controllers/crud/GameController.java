package org.example.controllers.crud;

import jakarta.validation.Valid;
import org.example.controllers.base.BaseController;
import org.example.input.GameCreateForm;
import org.example.input.GameEditForm;
import org.example.viewmodel.base.SearchForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/games")
public interface GameController extends BaseController {

    @GetMapping
    String listGames(
            @ModelAttribute("form") SearchForm searchForm,
            Model model
    );

    @GetMapping("/create")
    String createGameForm(Model model);

    @PostMapping("/create")
    String createGame(
            @Valid @ModelAttribute("form") GameCreateForm form,
            BindingResult bindingResult,
            Model model
    );

    @GetMapping("/edit/{id}")
    String editGameForm(@PathVariable int id, Model model);

    @PostMapping("/edit/{id}")
    String editGame(
            @PathVariable int id,
            @Valid @ModelAttribute("form") GameEditForm form,
            BindingResult bindingResult,
            Model model
    );
}
