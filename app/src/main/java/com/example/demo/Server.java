package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

@Component
public class Server {
    //@Autowired    <-- 예전방식
    private final HttpHandler requestHandler;

    //요즘 추세는 생성자로
    public Server(HttpHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void run() throws IOException {
        //서버 생성 및 start
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        HttpServer httpServer = HttpServer.create(address, 0);
        httpServer.createContext("/", requestHandler);
        httpServer.start();

        System.out.println("Listening http://localhost:8080/");
    }
}
