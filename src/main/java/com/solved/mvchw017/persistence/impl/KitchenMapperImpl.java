package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.persistence.KitchenRepository;
import com.solved.mvchw017.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

public class KitchenMapperImpl implements KitchenRepository {

    @Override
    public void create(Kitchen kitchen, Long restaurantId) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            KitchenRepository kitchenRepository = session.getMapper(KitchenRepository.class);
            kitchenRepository.create(kitchen,restaurantId);
        }
    }
}
