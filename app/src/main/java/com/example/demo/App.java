package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    public static void main(String[] args) throws IOException {

        // ApplicationContext 생성 방식중에서 Annotation 방식을 사용하여 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        App app = context.getBean(App.class);
        app.run();
    }

    private void run() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/", new RequestHandler());
        httpServer.start();
        System.out.println("Server started. Listening on " + httpServer.getAddress());
    }
}
