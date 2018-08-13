package ru.protei.tcpserver.database;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnectionManager {

    private static final String JDBC_DB_URL = "jdbc:h2:mem:";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "";

    @Autowired
    private Logger log;

    private Connection connection;

    public DBConnectionManager() {
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
//                log.info("Trying to connect to database...");
                connection = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASSWORD);
//                log.info("Connection to database established successfully");
            } catch (SQLException e) {
//                log.fatal("Failed to connect to database", e);
            }
        }
        return connection;
    }
}
