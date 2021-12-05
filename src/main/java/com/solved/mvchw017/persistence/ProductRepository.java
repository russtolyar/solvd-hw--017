package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Product;

public interface ProductRepository {

    void create(Product product, Long staffId);

}
