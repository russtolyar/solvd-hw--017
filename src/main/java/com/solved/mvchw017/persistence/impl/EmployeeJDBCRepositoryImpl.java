package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.domain.Employee;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.EmployeeRepository;

import java.sql.*;
import java.util.List;

public class EmployeeJDBCRepositoryImpl implements EmployeeRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Employee employee,Long passportId, Long addressId) {
        Connection connection = CONNECTION_POOL.getConnection();

    String sqlOperation = "insert into Employees (passport_id,address_id,first_name, last_name, position , department) values (?,?,?,?,?,?)";
        try (
    PreparedStatement preparedStatement
            = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)){
        preparedStatement.setLong(1,employee.getPassport().getId());
        preparedStatement.setLong(2, employee.getAddress().getId());
        preparedStatement.setString(3,employee.getName());
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
    }finally {
        CONNECTION_POOL.releaseConnection(connection);
    }

    }

    @Override
    public List<Employee> selectAll() {
        Connection connection = CONNECTION_POOL.getConnection();
         String sqlOperation = "Select e.id as employee_id,e.first_name as employee_name," +
                " p.id,p.number as employee_passport_number,p.expire_date as passport_expire_at" +
                "from Employees e right join Passports p \n" +
                "on p.id = e.passport_id;";

        List<Employee> employees = null;
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement(sqlOperation)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            employees = f;

        } catch (SQLException e) {
            throw new RuntimeException(" Cannot select the Employees with passports   ", e);
//        }finally {
//            CONNECTION_POOL.releaseConnection(connection);
        } return employees;
      }
}
