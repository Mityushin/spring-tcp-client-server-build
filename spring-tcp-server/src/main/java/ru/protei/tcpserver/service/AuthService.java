package ru.protei.tcpserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.dao.UserDAO;
import ru.protei.tcpserver.model.User;

@Component
public class AuthService {
    @Autowired
    private UserDAO userDAO;

    public boolean isAuth(User user) {
        return userDAO.exists(user);
    }
}
