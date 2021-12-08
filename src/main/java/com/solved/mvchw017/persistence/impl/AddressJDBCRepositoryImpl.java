package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.persistence.AddressRepository;
import com.solved.mvchw017.persistence.ConnectionPool;

import java.sql.*;


public class AddressJDBCRepositoryImpl implements AddressRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Addresses(city, street, house, flat) values(?,?,?,?) ";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getNumberHouse());
            preparedStatement.setInt(4, address.getNumberFlat());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                address.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create Address ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }


    }
}
