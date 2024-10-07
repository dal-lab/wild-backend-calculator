package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.InetSocketAddress;

@Configuration
public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        App app = context.getBean(App.class);
        app.run();
    }
    public void run() throws IOException {
        HttpHandler requestHandler = new RequestHandler();

        InetSocketAddress address = new InetSocketAddress("localhost",8080);
        HttpServer httpServer = HttpServer.create(address, 0);
        httpServer.createContext("/", requestHandler);
        httpServer.start();
        System.out.println("Listening on http://localhost:8080");
    }
}
