package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Staff;
import org.apache.ibatis.annotations.Param;

public interface StaffRepository {

    void create(@Param("staff") Staff staff, @Param("kitchenId") Long kitchenId);

}
