package ru.protei.tcpserver.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.dao.UserDAO;

@Component
public class AuthService {
    private Logger log;
    private UserDAO userDAO;

    public AuthService(Logger log, UserDAO userDAO) {
        this.log = log;
        this.userDAO = userDAO;
    }
}
