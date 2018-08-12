package ru.protei.tcpserver.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.protei.tcpserver.Controller;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Controller controller = context.getBean(Controller.class);
        controller.run();
    }
}
