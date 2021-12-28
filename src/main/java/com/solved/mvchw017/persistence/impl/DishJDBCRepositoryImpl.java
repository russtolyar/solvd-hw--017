package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.DishRepository;

import java.sql.*;

public class DishJDBCRepositoryImpl implements DishRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Long create(Dish dish, Long menuId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Dishes (menu_id, name, type) values (?,?,?)";
        Long id = null;
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, menuId);
            preparedStatement.setString(2, dish.getName());
            preparedStatement.setString(3, dish.getType());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                //dish.setId(resultSet.getLong(1));
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Dish   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return id;
    }

    @Override
    public Dish findById(Long id) {
        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "Select d.id, d.name, d.type  from Dishes d where d.id = ?";
        Dish dish = null;
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation)) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dish = new Dish();
                dish.setId(resultSet.getLong("id"));
                dish.setName(resultSet.getString("name"));
                dish.setType(resultSet.getString("type"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dish;
    }
}
