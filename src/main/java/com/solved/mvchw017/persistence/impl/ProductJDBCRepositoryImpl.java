package com.solved.mvchw017.persistence.impl;

import com.solved.mvchw017.domain.department.Product;
import com.solved.mvchw017.persistence.ConnectionPool;
import com.solved.mvchw017.persistence.ProductRepository;

import java.sql.*;

public class ProductJDBCRepositoryImpl implements ProductRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Product product, Long staffId) {

        Connection connection = CONNECTION_POOL.getConnection();

        String sqlOperation = "insert into Products (staff_id,name) values (?,?)";
        try (
                PreparedStatement preparedStatement
                        = connection.prepareStatement(sqlOperation, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setLong(1,staffId);
            preparedStatement.setString(2,product.getName());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                product.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot create the Product   ", e);
        }finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }
}
