package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.department.Staff;

public interface StaffRepository {

    void create(Staff staff, Long kitchenId);

}
