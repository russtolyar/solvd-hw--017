package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.exception.ProcessingException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class ConnectionPool {


    private final List<Connection> connections;
    private static ConnectionPool connectionPoolInstance;
    public static Integer connectionPoolSize = Integer.parseInt(Config.POOLSIZE);

    private ConnectionPool(Integer connectionPoolSize) {

        try {
            Class.forName(Config.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ProcessingException(" problem with driver  " + e.getMessage(), e);
        }

        connections = new ArrayList<>();
        IntStream.range(0, connectionPoolSize)
                .boxed()
                .forEach(index -> connections.add(createConnection()));
    }

    private Connection createConnection() {
//        Connection connection;
        try {
//            connection =
            return
                    DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(" No connection!!!   ", e);
        }
//        return connection;
    }

    public static ConnectionPool getInstance() {
        if (connectionPoolInstance == null) {
            connectionPoolInstance = new ConnectionPool(connectionPoolSize);
        }
        return connectionPoolInstance;
    }

    public Connection getConnection() {
//        LOGGER.debug("get My Connection");
//        if (connections.size() == 0) {
//            try {
//                Thread.currentThread().join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        return connections.remove(0);
    }

    public void releaseConnection(Connection connection) {
//        LOGGER.debug("Release Connection");
        connections.add(connection);
    }


}
