package com.solved.mvchw017.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String DRIVER;
    public static String USER;
    public static String URL;
    public static String PASSWORD;
    public static String POOLSIZE;


    static {
        Properties properties = new Properties();
        String pass = "src/main/resources/config.properties";
        try
                (FileInputStream fileInputStream = new FileInputStream(pass)) {
            properties.load(fileInputStream);

            DRIVER = properties.getProperty("driver");
            USER = properties.getProperty("user");
            URL = properties.getProperty("url");
            PASSWORD = properties.getProperty("password");
            POOLSIZE = properties.getProperty("poolSize");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
