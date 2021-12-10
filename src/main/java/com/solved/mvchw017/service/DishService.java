package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.menu.Dish;

public interface DishService {

    Dish create (Dish dish, Long menuId);
}
