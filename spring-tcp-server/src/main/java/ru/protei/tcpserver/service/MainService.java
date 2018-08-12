package ru.protei.tcpserver.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MainService {

    private Logger log;
    private AuthService authService;
    private WordService wordService;

    public MainService(Logger log, AuthService authService, WordService wordService) {
        this.log = log;
        this.authService = authService;
        this.wordService = wordService;
    }

    public String resolveCommand(String request) {
        String response = null;



        return response;
    }
}
