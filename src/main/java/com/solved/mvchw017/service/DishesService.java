package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.menu.Food;

public interface DishesService {
    Food create (Food food, Long menuId);
}
