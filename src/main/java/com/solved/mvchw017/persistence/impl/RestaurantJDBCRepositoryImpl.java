package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Restaurant;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.RestaurantRepository;

import java.sql.*;


public class RestaurantJDBCRepositoryImpl implements RestaurantRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Restaurant restaurant) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Restaurants(name, date_Of_Foundation) values (?,?)";
        try (PreparedStatement preparedStatement
                     = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, restaurant.getName());
            preparedStatement.setDate(2, Date.valueOf(restaurant.getDateOfFoundation()));

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                restaurant.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Restaurant   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
