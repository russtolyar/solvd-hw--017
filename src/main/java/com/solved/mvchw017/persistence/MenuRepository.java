package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.menu.Menu;

public interface MenuRepository {

    Menu create (Menu menu, Long restaurantId);

}
