package ru.protei.tcpserver.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.dao.WordDAO;

@Component
public class WordService {

    private Logger log;
    private WordDAO wordDAO;

    public WordService(Logger log, WordDAO wordDAO) {
        this.log = log;
        this.wordDAO = wordDAO;
    }
}
