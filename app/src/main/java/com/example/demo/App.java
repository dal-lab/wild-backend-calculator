package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"com.example.demo"})
public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Server server = context.getBean(Server.class);
        server.run();
    }
}
