package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.DishRepository;

import java.sql.*;

public class DishJDBCRepositoryImpl implements DishRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Dish dish, Long menuId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Dishes (menu_id, name, type) values (?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, menuId);
            preparedStatement.setString(2, dish.getName());
            preparedStatement.setString(3, dish.getType());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                dish.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Dish   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
