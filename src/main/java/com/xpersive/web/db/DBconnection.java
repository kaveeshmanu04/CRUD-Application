package com.xpersive.web.db;

import com.xpersive.web.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static Connection connection;

    public static Connection getConnection() throws Exception{
        if(connection==null){
            ApplicationProperties properties = ApplicationProperties.getInstance();
            Class.forName(properties.get("sql.connection.driver"));
            connection = DriverManager.getConnection(properties.get("sql.connection.url"),properties.get("sql.connection.username"),properties.get("sql.connection.password"));

        }
        return connection;
    }
}
