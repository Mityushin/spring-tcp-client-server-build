package ru.protei.tcpserver.config;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.protei.tcpserver.Controller;
import ru.protei.tcpserver.dao.UserDAO;
import ru.protei.tcpserver.dao.WordDAO;
import ru.protei.tcpserver.database.DBConnectionManager;
import ru.protei.tcpserver.service.AuthService;
import ru.protei.tcpserver.service.MainService;
import ru.protei.tcpserver.service.WordService;

@Configuration
public class ApplicationConfig {

    @Autowired
    Environment environment;

    @Bean
    public Logger logger() {
        BasicConfigurator.configure();
        return Logger.getLogger(ApplicationConfig.class);
    }

    @Bean
    public DBConnectionManager dbConnectionManager() {
        return new DBConnectionManager();
    }

    @Bean
    public UserDAO userDAO(Logger logger, DBConnectionManager dbConnectionManager) {
        return new UserDAO(logger, dbConnectionManager);
    }

    @Bean
    public WordDAO wordDAO(Logger logger, DBConnectionManager dbConnectionManager) {
        return new WordDAO(logger, dbConnectionManager);
    }

    @Bean
    public AuthService authService(Logger logger, UserDAO userDAO) {
        return new AuthService(logger, userDAO);
    }

    @Bean
    public MainService mainService(Logger logger, AuthService authService, WordService wordService) {
        return new MainService(logger, authService, wordService);
    }

    @Bean
    public WordService wordService(Logger logger, WordDAO wordDAO) {
        return new WordService(logger, wordDAO);
    }

    @Bean
    public Controller controller(Logger logger, MainService mainService) {
        return new Controller(logger, mainService);
    }
}
