package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.department.Kitchen;

public interface KitchenService {
    Kitchen create (Kitchen kitchen, Long restaurantId);
}
