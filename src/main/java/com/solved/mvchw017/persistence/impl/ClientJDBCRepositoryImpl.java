package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Client;
import com.solved.mvchw017.persistence.ClientRepository;
import com.solved.mvchw017.persistence.ConnectionPool;

import java.sql.*;

public class ClientJDBCRepositoryImpl implements ClientRepository {


    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    public void print() {
        System.out.println("Print is working");
    }

    public void linkClientDish(Long clientId, Long dishId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Client_dishes (client_id, dish_id) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, clientId);
            preparedStatement.setLong(2, dishId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                cl.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Client_Dishes connection   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

      {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Client_drinks (client_id, drink_id) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, clientId);
            preparedStatement.setLong(2, drinkId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                Client_drinks.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Client_Drinks connection   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void create(Client client, Long addressId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Client (address_id, name, dob) values (?,?,?)";
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
            throw new RuntimeException(" Cannot create the Client   ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }


    }
}
