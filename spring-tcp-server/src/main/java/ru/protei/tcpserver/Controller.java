package ru.protei.tcpserver;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.protei.tcpserver.service.MainService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class Controller {
    private Logger log;
    private MainService mainService;

    public Controller(Logger log, MainService mainService) {
        this.log = log;
        this.mainService = mainService;
    }

    public void run() {
        int serverPort = 3345;
        ServerSocket server = null;
        try {
            log.info("Trying to start server on port " + serverPort + "...");
            server = new ServerSocket(serverPort);
            log.info("Server started successfully");

        } catch (IOException e) {
            log.fatal("Failed to create socket!", e);
            System.exit(2);
        }

        while (!server.isClosed()) {
            try {
                log.info("Waiting for client...");
                serveClient(server.accept());
            } catch (IOException e) {
                log.fatal("Cannot accept client!", e);
            }
        }
    }

    private void serveClient(Socket client) {
        log.info("Get client");
        try (DataInputStream in = new DataInputStream(client.getInputStream())) {
            try (DataOutputStream out = new DataOutputStream(client.getOutputStream())) {
                String str;
                while (!client.isClosed()) {
                    str = in.readUTF();
                    str = mainService.resolveCommand(str);
                    out.writeUTF(str);
                }
            }
        } catch (IOException e) {
            log.error("Lose client!", e);
        }
    }
}
