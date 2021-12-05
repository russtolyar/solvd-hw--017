package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Kitchen;

public interface KitchenRepository {

    void create(Kitchen kitchen, Long restaurantId);
}
