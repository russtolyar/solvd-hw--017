package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.menu.Food;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.DishesRepository;

import java.sql.*;

public class DishesJDBCRepositoryImpl implements DishesRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Food food, Long menuId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Dishes (menu_id, name, type) values (?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1, menuId);
            preparedStatement.setString(2, food.getName());
            preparedStatement.setString(3, food.getType());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                food.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Food   ", e);
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
