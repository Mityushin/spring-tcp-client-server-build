package ru.protei.tcpserver.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.annotation.Loggable;
import ru.protei.tcpserver.database.DBConnectionManager;
import ru.protei.tcpserver.model.User;

@Component
public class UserDAO implements CRUD<User> {
    private static final String SQL_TABLE_COLUMN_ID = "ID";
    private static final String SQL_TABLE_COLUMN_NAME = "NAME";
    private static final String SQL_TABLE_COLUMN_PASSWORD = "PASSWORD";
    private static final String SQL_CREATE_TABLE_WORD = "CREATE TABLE USER (" +
            "ID INTEGER NOT NULL AUTO_INCREMENT, " +
            "NAME VARCHAR(40) NOT NULL, " +
            "PASSWORD VARCHAR(40))";
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM USER WHERE USER.NAME = ?";
    private static final String SQL_CREATE_USER = "INSERT INTO USER (NAME, PASSWORD) VALUES (?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE USER SET USER.PASSWORD = ? WHERE USER.NAME = ?";
    private static final String SQL_DELETE_USER_BY_TITLE = "DELETE FROM USER WHERE USER.NAME = ?";
    private static final String SQL_CHECK_EXISTS_BY_TITLE = "SELECT * FROM USER WHERE USER.NAME = ?";

    @Autowired
    private DBConnectionManager database;

    @Loggable
    public User create(User user) {
        return null;
    }

    @Loggable
    public User update(User user) {
        return null;
    }

    @Loggable
    public User delete(User user) {
        return null;
    }

    @Loggable
    public boolean exists(User user) {
        return true;
    }
}
