package com.solved.mvchw017.persistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionHolder {

    private static final String CONFIG_FILE_PATH = "mybatis-config.xml";
    private static final SqlSessionFactory SQL_SESSION_FACTORY;

    static {
        SQL_SESSION_FACTORY = buildSessionFactory();
    }

    private static SqlSessionFactory buildSessionFactory() {
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(CONFIG_FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException(" Cannot work with  Mybatis config  " + e.getLocalizedMessage());
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder.build(inputStream);

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return SQL_SESSION_FACTORY;
    }

}
