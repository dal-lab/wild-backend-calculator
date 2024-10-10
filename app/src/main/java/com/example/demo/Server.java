package com.example.demo;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.springframework.stereotype.Component;

@Component
public class Server {

    private final HttpHandler requestHandler;

    public Server(HttpHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        HttpServer httpServer = HttpServer.create(address, 0);
        httpServer.createContext("/", requestHandler);
        httpServer.start();

        System.out.println("Listening on http://localhost:8080");
    }
}
