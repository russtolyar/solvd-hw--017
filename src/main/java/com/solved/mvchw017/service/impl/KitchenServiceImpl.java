package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Employee;
import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.domain.department.Staff;
import com.solved.mvchw017.persistence.KitchenRepository;
import com.solved.mvchw017.persistence.impl.KitchenJDBCRepositoryImpl;
import com.solved.mvchw017.service.EmployeeService;
import com.solved.mvchw017.service.KitchenService;
import com.solved.mvchw017.service.StaffService;

import java.util.List;
import java.util.stream.Collectors;

public class KitchenServiceImpl implements KitchenService {

    private final KitchenRepository kitchenRepository;
    private final StaffService staffService;
    private final EmployeeService employeeService;

    public KitchenServiceImpl() {
        this.kitchenRepository = new KitchenJDBCRepositoryImpl();
        this.staffService = new StaffServiceImpl();
        this.employeeService = new EmployeeServiceImpl();
    }

    @Override
    public Kitchen create(Kitchen kitchen, Long restaurantId) {
        kitchen.setId(null);
        kitchenRepository.create(kitchen, restaurantId);

        if (kitchen.getStaff() != null) {
            List<Staff> staffList = kitchen.getStaff()
                    .stream()
                    .map(staff -> staffService.create(staff, kitchen.getId()))
                    .collect(Collectors.toList());
            kitchen.setStaff(staffList);
        }
        if (kitchen.getEmployees() != null) {
            List<Employee> employees = kitchen.getEmployees()
                    .stream()
                    .map(employee -> employeeService.create(employee))
                    .collect(Collectors.toList());
            kitchen.setEmployees(employees);
        }

        return kitchen;
    }
}
