package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.menu.Menu;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.MenuRepository;

import java.sql.*;

public class MenuJDBCRepositoryImpl implements MenuRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Menu create(Menu menu, Long restaurantId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Menues (restaurant_id, type) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, restaurantId);
            preparedStatement.setString(2, menu.getType());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                menu.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Menu   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return menu;
    }
}
