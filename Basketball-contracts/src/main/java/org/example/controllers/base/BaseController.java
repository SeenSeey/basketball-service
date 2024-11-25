package org.example.controllers.base;

import org.example.viewmodel.base.BaseViewModel;

public interface BaseController {

//    Создаёт базовую модель представления
    BaseViewModel createBaseViewModel(String title);
}
