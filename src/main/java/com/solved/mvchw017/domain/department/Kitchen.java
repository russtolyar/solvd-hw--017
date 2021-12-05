package com.solved.mvchw017.domain.department;


import com.solved.mvchw017.domain.Employee;

import java.util.List;

public class Kitchen {

    private Long id;

    private List<Employee> employees;
    private List<Staff> staff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
