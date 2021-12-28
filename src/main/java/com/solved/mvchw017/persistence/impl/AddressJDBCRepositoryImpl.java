package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Address;
import com.solved.mvchw017.persistence.AddressRepository;
import com.solved.mvchw017.persistence.ConnectionPool;

import java.sql.*;


public class AddressJDBCRepositoryImpl implements AddressRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Address create(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "insert into Addresses(city, street, house, flat) values(?,?,?,?) ";
        Long id = null;
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
                id = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create Address ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public void delete(Address address) {

        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "delete from Addresses where city = (?) and street = (?); ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlOperation)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());

            preparedStatement.executeUpdate();

        } catch (SQLException  e) {
            throw new RuntimeException("Cannot Delete Address " + e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Address select(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "select * from Addresses where city = (?) and street = (?); ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlOperation)) {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());

            ResultSet resultSet = preparedStatement.executeQuery();

            Address addressOutput = new Address();

            while (resultSet.next()) {
                addressOutput.setId(resultSet.getLong("id"));
                addressOutput.setCity(resultSet.getString("city"));
                addressOutput.setStreet(resultSet.getString("street"));
                addressOutput.setNumberHouse(resultSet.getInt("house"));
                addressOutput.setNumberFlat(resultSet.getInt("flat"));
            }

            return addressOutput;

        }  catch (SQLException  e) {
            throw new RuntimeException("Cannot Select Address " + e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Address address, Address addressNew) {
        Connection connection = CONNECTION_POOL.getConnection();
        String sqlOperation = "update Addresses set city = ?, street = ?,house = ?,flat = ? where id = 1";
//                "city = ?, street = ?, house = ?, flat = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlOperation)) {
            preparedStatement.setString(1, addressNew.getCity());
            preparedStatement.setString(2, addressNew.getStreet());
            preparedStatement.setInt(3, addressNew.getNumberHouse());
            preparedStatement.setInt(4, addressNew.getNumberFlat());

//            preparedStatement.setString(5, address.getCity());
//            preparedStatement.setString(6, address.getStreet());
//            preparedStatement.setInt(7, address.getNumberHouse());
//            preparedStatement.setInt(8, address.getNumberFlat());

            preparedStatement.executeUpdate();

        }catch (SQLException  e) {
            throw new RuntimeException("Cannot Update Address " + e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

}
