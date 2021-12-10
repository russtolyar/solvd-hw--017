package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.domain.Employee;
import com.solved.mvchw017.domain.Passport;
import com.solved.mvchw017.persistence.EmployeeRepository;
import com.solved.mvchw017.persistence.impl.EmployeeJDBCRepositoryImpl;
import com.solved.mvchw017.persistence.impl.EmployeeMapperImpl;
import com.solved.mvchw017.service.AddressService;
import com.solved.mvchw017.service.EmployeeService;
import com.solved.mvchw017.service.PassportService;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PassportService passportService;
    private final AddressService addressService;

    public EmployeeServiceImpl() {
//        this.employeeRepository = new EmployeeJDBCRepositoryImpl();
        this.employeeRepository = new EmployeeMapperImpl();
        this.passportService = new PassportServiceImpl();
        this.addressService = new AddressServiceImpl();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);

        if (employee.getPassport() != null) {
            Passport passport = passportService.create(employee.getPassport());
            employee.setPassport(passport);
        }
        if (employee.getAddress() != null) {
            Address address = addressService.create(employee.getAddress());
            employee.setAddress(address);
        }
        employeeRepository.create(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findWithAddress() {
        return employeeRepository.findWithAddress();
    }

    @Override
    public Employee update(String new1,Employee employee) {
       return employeeRepository.update(new1,employee);
    }


}
