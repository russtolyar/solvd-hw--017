package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductRepository {

    void create(@Param("product") Product product,@Param("staffId") Long staffId);

}
