package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.domain.menu.Dish;
import com.solved.mvchw017.persistence.ClientRepository;
import com.solved.mvchw017.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientJDBCRepositoryImpl implements ClientRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public void linkClientDish(Long clientId, Long dishId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Client_dishes (client_id, dish_id) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, clientId);
            preparedStatement.setLong(2, dishId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Client_Dishes connection   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public void linkClientDrink(Long clientId, Long drinkId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Client_drinks (client_id, drink_id) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, clientId);
            preparedStatement.setLong(2, drinkId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Client_Drinks connection   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }


    @Override
    public void create(Client client, Long addressId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Clients (address_id, name, dob) values (?,?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, addressId);
            preparedStatement.setString(2, client.getName());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(client.getDob()));

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                client.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Client   " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    }
