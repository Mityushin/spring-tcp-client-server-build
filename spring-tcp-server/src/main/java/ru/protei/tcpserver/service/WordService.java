package ru.protei.tcpserver.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.dao.WordDAO;
import ru.protei.tcpserver.model.Word;

@Component
public class WordService {

    @Autowired
    private WordDAO wordDAO;

    public boolean createWord(Word word) {
        return wordDAO.create(word);
    }

    public boolean updateWord(Word word) {
        return wordDAO.update(word);
    }

    public boolean deleteWord(Word word) {
        return wordDAO.delete(word);
    }

    public boolean existsWord(Word word) {
        return wordDAO.exists(word);
    }
}
