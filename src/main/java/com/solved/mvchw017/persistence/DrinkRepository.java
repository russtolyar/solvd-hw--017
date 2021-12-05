package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.menu.Drink;

public interface DrinkRepository {

    void create (Drink drink, Long menuId);
}
