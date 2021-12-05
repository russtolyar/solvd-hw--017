package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.menu.Menu;

public interface MenuService {

    Menu create(Menu menu, Long restaurantId);
}
