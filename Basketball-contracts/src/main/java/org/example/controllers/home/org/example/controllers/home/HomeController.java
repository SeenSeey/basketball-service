package org.example.controllers.home.org.example.controllers.home;

import org.example.controllers.base.BaseController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface HomeController extends BaseController {

//    Отображает главную страницу
    @GetMapping()
    String index(Model model);
}
