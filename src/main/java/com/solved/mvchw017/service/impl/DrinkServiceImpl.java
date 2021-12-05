package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.persistence.DrinkRepository;
import com.solved.mvchw017.persistence.impl.DrinkJDBCRepositoryImpl;
import com.solved.mvchw017.service.DrinkService;

public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkServiceImpl() {
        this.drinkRepository = new DrinkJDBCRepositoryImpl();
    }

    @Override
    public Drink create(Drink drink, Long menuId) {
        drink.setId(null);
        drinkRepository.create(drink, menuId);
        return drink;
    }
}
