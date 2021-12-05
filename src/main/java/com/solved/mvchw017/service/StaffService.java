package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.department.Staff;

public interface StaffService {
    Staff create(Staff staff, Long kitchenId);
}
