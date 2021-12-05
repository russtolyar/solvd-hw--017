package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.menu.Food;

public interface DishesRepository {

    void create (Food food, Long menuId);
}
