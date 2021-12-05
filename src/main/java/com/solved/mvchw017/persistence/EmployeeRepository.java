package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

    void create(Employee employee, Long passportId, Long addressId);
    List<Employee> selectAll();
}
