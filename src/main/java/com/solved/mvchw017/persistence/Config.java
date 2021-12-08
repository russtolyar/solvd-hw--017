package com.solved.mvchw017.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static final String DRIVER;
    public static final String USER;
    public static final String URL;
    public static final String PASSWORD;
    public static final String POOLSIZE;


    static {
        DRIVER = getValue("driver");
        USER = getValue("user");
        URL = getValue("url");
        PASSWORD = getValue("password");
        POOLSIZE = getValue("poolSize");

    }

    public static String getValue(String info) {
        Properties properties = new Properties();
        String pass = "src/main/resources/config.properties";
        try
                (FileInputStream fileInputStream = new FileInputStream(pass)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(info);
    }

}
