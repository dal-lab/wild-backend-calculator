package com.example.demo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.run();
    }

    private void run() throws IOException {
        InetSocketAddress address = new InetSocketAddress("localhost",8080);
        HttpServer httpServer = HttpServer.create(address, 0);
        httpServer.start();
        httpServer.createContext()
    }
}
