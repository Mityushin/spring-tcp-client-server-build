package ru.protei.tcpserver.config;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.protei.tcpserver.Controller;
import ru.protei.tcpserver.aspect.WebServiceLogger;
import ru.protei.tcpserver.dao.UserDAO;
import ru.protei.tcpserver.dao.WordDAO;
import ru.protei.tcpserver.database.DBConnectionManager;
import ru.protei.tcpserver.service.AuthService;
import ru.protei.tcpserver.service.MainService;
import ru.protei.tcpserver.service.WordService;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationConfig {

    @Bean
    public Logger log() {
        BasicConfigurator.configure();
        return Logger.getLogger(WebServiceLogger.class);
    }

    @Bean
    public DBConnectionManager dbConnectionManager() {
        return new DBConnectionManager();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAO();
    }

    @Bean
    public WordDAO wordDAO() {
        return new WordDAO();
    }

    @Bean
    public AuthService authService() {
        return new AuthService();
    }

    @Bean
    public MainService mainService() {
        return new MainService();
    }

    @Bean
    public WordService wordService() {
        return new WordService();
    }

    @Bean
    public Controller controller() {
        return new Controller();
    }

    @Bean
    public WebServiceLogger webServiceLogger() {
        return new WebServiceLogger();
    }
}
