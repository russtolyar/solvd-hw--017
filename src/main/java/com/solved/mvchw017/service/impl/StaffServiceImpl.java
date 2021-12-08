package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.department.Product;
import com.solved.mvchw017.domain.department.Staff;
import com.solved.mvchw017.persistence.StaffRepository;
import com.solved.mvchw017.persistence.impl.StaffJDBCRepositoryImpl;
import com.solved.mvchw017.service.ProductService;
import com.solved.mvchw017.service.StaffService;

import java.util.List;
import java.util.stream.Collectors;

public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final ProductService productService;

    public StaffServiceImpl() {
        this.staffRepository = new StaffJDBCRepositoryImpl();
        this.productService = new ProductServiceImpl();
    }

    @Override
    public Staff create(Staff staff, Long kitchenId) {
        staff.setId(null);
        staffRepository.create(staff, kitchenId);

        if (staff.getProducts() != null) {
            List<Product> products = staff.getProducts()
                    .stream()
                    .map(product -> productService.create(product, staff.getId()))
                    .collect(Collectors.toList());
            staff.setProducts(products);
        }
        return staff;
    }
}
