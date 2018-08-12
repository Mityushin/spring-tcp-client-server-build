package ru.protei.tcpserver.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.database.DBConnectionManager;
import ru.protei.tcpserver.model.Word;

@Component
public class WordDAO implements CRUD<Word> {

    private static final String SQL_TABLE_COLUMN_ID = "ID";
    private static final String SQL_TABLE_COLUMN_TITLE = "TITLE";
    private static final String SQL_TABLE_COLUMN_DESCRIPTION = "DESCRIPTION";
    private static final String SQL_CREATE_TABLE_WORD = "CREATE TABLE WORD (" +
            "ID INTEGER NOT NULL AUTO_INCREMENT, " +
            "TITLE VARCHAR(20) NOT NULL UNIQUE, " +
            "DESCRIPTION VARCHAR(40))";
    private static final String SQL_FIND_BY_TITLE = "SELECT * FROM WORD WHERE WORD.TITLE = ?";
    private static final String SQL_FIND_BY_TITLE_REGEXP = "SELECT * FROM WORD WHERE WORD.TITLE LIKE ?";
    private static final String SQL_CREATE_WORD = "INSERT INTO WORD (TITLE, DESCRIPTION) VALUES (?, ?)";
    private static final String SQL_UPDATE_WORD = "UPDATE WORD SET WORD.DESCRIPTION = ? WHERE WORD.TITLE = ?";
    private static final String SQL_DELETE_WORD_BY_TITLE = "DELETE FROM WORD WHERE WORD.TITLE = ?";
    private static final String SQL_CHECK_EXISTS_BY_TITLE = "SELECT * FROM WORD WHERE WORD.TITLE = ?";

    private Logger log;
    private DBConnectionManager database;

    public WordDAO(Logger log, DBConnectionManager database) {
        this.log = log;
        this.database = database;
    }

    public Word create(Word word) {
        return null;
    }

    public Word update(Word word) {
        return null;
    }

    public Word delete(Word word) {
        return null;
    }

    public boolean exists(Word word) {
        return false;
    }
}
