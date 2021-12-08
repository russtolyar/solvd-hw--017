package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.department.Kitchen;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.KitchenRepository;

import java.sql.*;

public class KitchenJDBCRepositoryImpl implements KitchenRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Kitchen kitchen, Long restaurantId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Kitchens (restaurant_id) values (?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, restaurantId);


            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                kitchen.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Kitchen   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
