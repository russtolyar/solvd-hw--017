package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRepository {

    void create(@Param("employee") Employee employee);

    List<Employee> findAll();

    List<Employee> findWithAddress();
    Employee update (String new1,Employee employee);


}
