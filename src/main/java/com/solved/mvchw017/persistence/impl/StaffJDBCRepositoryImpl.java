package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.department.Staff;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.StaffRepository;

import java.sql.*;

public class StaffJDBCRepositoryImpl implements StaffRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Staff staff, Long kitchenId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Staff (kitchen_id,name, type) values (?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1,kitchenId);
            preparedStatement.setString(2,staff.getName());
            preparedStatement.setString(3, staff.getType());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                staff.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Staff   ", e);
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
