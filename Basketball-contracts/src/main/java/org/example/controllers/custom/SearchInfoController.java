package org.example.controllers.custom;

import org.example.controllers.base.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/search")
public interface SearchInfoController extends BaseController {

//    Отображает информацию о игроке
    @GetMapping("/{fullName}")
    String search(@PathVariable String fullName, Model model);
}
