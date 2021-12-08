package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Passport;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.PassportRepository;

import java.sql.*;
import java.util.List;

public class PassportJDBCRepositoryImpl implements PassportRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Passport passport) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Passports (number, expire_date) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, passport.getNumber());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(passport.getExpiredAt()));

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                passport.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Passport   " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    @Override
    public List<Passport> findAll() {
        return null;
    }
}
