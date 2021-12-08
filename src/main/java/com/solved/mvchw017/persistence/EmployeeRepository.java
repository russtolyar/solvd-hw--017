package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeRepository {

    void create(@Param("employee") Employee employee);
//    ,@Param("passportId") Long passportId,@Param("addressId") Long addressId);

//    List<Employee> selectAll();

    List<Employee> findAll();
}
