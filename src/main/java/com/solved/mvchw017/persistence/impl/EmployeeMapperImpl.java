package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Employee;
import com.solved.mvchw017.persistence.EmployeeRepository;
import com.solved.mvchw017.persistence.MyBatisSessionHolder;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeRepository {
    @Override
    public void create(Employee employee) {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            employeeRepository.create(employee);
        }
    }

    @Override
    public List<Employee> findAll() {
        try (SqlSession session = MyBatisSessionHolder.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = session.getMapper(EmployeeRepository.class);
            return employeeRepository.findAll();
        }
    }
}