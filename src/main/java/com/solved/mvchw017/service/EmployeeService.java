package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.Employee;

import java.util.List;


public interface EmployeeService {

    Employee create(Employee employee);

    List<Employee> findAll();
    List<Employee> findWithAddress();
    Employee update(String new1,Employee employee);

}
