package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Kitchen;
import org.apache.ibatis.annotations.Param;

public interface KitchenRepository {

    void create(@Param("kitchen") Kitchen kitchen,@Param("restaurantId") Long restaurantId);
}
