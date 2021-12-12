package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.domain.Employee;
import com.solved.mvchw017.domain.Passport;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solved.mvchw017.persistence.ConnectionPool.getInstance;


public class EmployeeJDBCRepositoryImpl implements EmployeeRepository {

    private static final ConnectionPool CONNECTION_POOL = getInstance();

    @Override
    public void create(Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Employees (passport_id,address_id,first_name, last_name, position , department) values (?,?,?,?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, employee.getPassport().getId());
            preparedStatement.setLong(2, employee.getAddress().getId());
            preparedStatement.setString(3, employee.getName());
            preparedStatement.setString(4, employee.getLastName());
            preparedStatement.setString(5, employee.getPosition());
            preparedStatement.setString(6, employee.getDepartment());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                employee.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Employee   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public List<Employee> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation =
                "Select e.id as employee_ID, e.first_name, e.last_name, e.position, e.department," +
                " p.id as passport_ID, p.number from Employees e right join  Passports p " +
                "on p.id = e.passport_id ";

        List<Employee> employeesFindAll = new ArrayList<>();
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("employee_ID"));
                employee.setName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setDepartment(resultSet.getString("department"));

                Passport passport = new Passport();
                passport.setId(resultSet.getLong("passport_ID"));
                passport.setNumber(resultSet.getString("number"));
                employee.setPassport(passport);

                System.out.println(employee);

                employeesFindAll.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeesFindAll;

    }

    @Override
    public List<Employee> findWithAddress() {
        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "Select e.id, e.first_name, e.last_name, e.position, e.department," +
                " p.id, p.number,a.id, a.city, a.street from Addresses a left join Employees e " +
                " on a.id = e.address_id  left join  Passports p " +
                "on p.id = e.passport_id where a.city like '%ins%' or a.street like 'D%'";

        List<Employee> employeesFindWithAddress = new ArrayList<>();
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setDepartment(resultSet.getString("department"));

                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                employee.setAddress(address);

                Passport passport = new Passport();
                passport.setId(resultSet.getLong("id"));
                passport.setNumber(resultSet.getString("number"));
                employee.setPassport(passport);

                System.out.println(employee);

                employeesFindWithAddress.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException("incorrect Select with address!  - " + e.getMessage(), e);
        }

        return employeesFindWithAddress;

    }

    @Override
    public Employee update(String new1,Employee employee) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "Update Employees set last_name = (?) where id = (?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, new1);
            preparedStatement.setLong(2, employee.getId());

            preparedStatement.executeUpdate();
            System.out.println(employee);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                employee.setId(resultSet.getLong(1));
//            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot update the Employee   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return employee;
    }


}
