package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.department.Product;
import com.solved.mvchw017.persistence.ProductRepository;
import com.solved.mvchw017.persistence.impl.ProductJDBCRepositoryImpl;
import com.solved.mvchw017.service.ProductService;

public class ProductServiceImpl implements ProductService {
   private final  ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductJDBCRepositoryImpl();
    }

    @Override
    public Product create(Product product,Long staffId) {
        product.setId(null);
        productRepository.create(product,staffId);

        return product;
    }
}
