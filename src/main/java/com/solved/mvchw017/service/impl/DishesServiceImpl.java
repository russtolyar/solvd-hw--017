package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.menu.Food;
import com.solved.mvchw017.persistence.DishesRepository;
import com.solved.mvchw017.persistence.impl.DishesJDBCRepositoryImpl;
import com.solved.mvchw017.service.DishesService;

public class DishesServiceImpl implements DishesService {

    private final DishesRepository dishesRepository;

    public DishesServiceImpl() {
        this.dishesRepository = new DishesJDBCRepositoryImpl();
    }

    @Override
    public Food create(Food food, Long menuId) {
        food.setId(null);
        dishesRepository.create(food,menuId);
        return food;
    }
}
