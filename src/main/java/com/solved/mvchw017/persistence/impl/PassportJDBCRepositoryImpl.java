package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.Passport;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.PassportRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "select * from Passports";
        List<Passport> passportsFindAll = new ArrayList<>();
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Passport passport = new Passport();
                passport.setId(resultSet.getLong("id"));
                passport.setNumber(resultSet.getString("number"));
                passport.setExpiredAt((resultSet.getDate("expire_date")).toLocalDate().atStartOfDay());
                System.out.println(passport);

                passportsFindAll.add(passport);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return passportsFindAll;

        }
    }
