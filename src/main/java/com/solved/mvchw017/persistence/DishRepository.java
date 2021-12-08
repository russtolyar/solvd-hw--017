package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.menu.Dish;

public interface DishRepository {

    void create (Dish dish, Long menuId);
}
