package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.menu.Drink;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.DrinkRepository;

import java.sql.*;

public class DrinkJDBCRepositoryImpl implements DrinkRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Drink drink, Long menuId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Drinks (menu_id, name, isAlcoholic) values (?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, menuId);
            preparedStatement.setString(2, drink.getName());
            preparedStatement.setBoolean(3, drink.isAlcoholic());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                drink.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Drink   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
