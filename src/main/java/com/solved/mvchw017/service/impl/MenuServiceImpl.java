package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.domain.menu.Menu;
import com.solved.mvchw017.persistence.MenuRepository;
import com.solved.mvchw017.persistence.impl.MenuJDBCRepositoryImpl;
import com.solved.mvchw017.service.DishService;
import com.solved.mvchw017.service.DrinkService;
import com.solved.mvchw017.service.MenuService;

import java.util.List;
import java.util.stream.Collectors;

public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final DrinkService drinkService;
    private final DishService dishService;

    public MenuServiceImpl() {
        this.menuRepository = new MenuJDBCRepositoryImpl();
        this.drinkService = new DrinkServiceImpl();
        this.dishService = new DishServiceImpl();
    }

    @Override
    public Menu create(Menu menu, Long restaurantId) {
        menu.setId(null);
        menuRepository.create(menu, restaurantId);

        if (menu.getDrinks() != null) {
            List<Drink> drinks = menu.getDrinks()
                    .stream()
                    .map(drink -> drinkService.create(drink, menu.getId()))
                    .collect(Collectors.toList());
            menu.setDrinks(drinks);
        }
        if (menu.getDishes() != null) {
            List<Dish> dishes = menu.getDishes()
                    .stream()
                    .map(dish -> dishService.create(dish, menu.getId()))
                    .collect(Collectors.toList());
            menu.setDishes(dishes);
        }
        return menu;
    }
}
