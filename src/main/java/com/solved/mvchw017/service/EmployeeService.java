package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create (Employee employee,Long passportId, Long addressId);
    List<Employee> selectAll();
}
