package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class Server {
    private final HttpHandler requestHandler;

    public Server(HttpHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void run() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/", requestHandler);
        httpServer.start();
        System.out.println("Server started. Listening on " + httpServer.getAddress());
    }

}
