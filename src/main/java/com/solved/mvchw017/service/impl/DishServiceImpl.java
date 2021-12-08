package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.persistence.DishRepository;
import com.solved.mvchw017.persistence.impl.DishJDBCRepositoryImpl;
import com.solved.mvchw017.service.DishService;

public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    public DishServiceImpl() {
        this.dishRepository = new DishJDBCRepositoryImpl();
    }

    @Override
    public Dish create(Dish dish, Long menuId) {
        dish.setId(null);
        dishRepository.create(dish, menuId);
        return dish;
    }
}
