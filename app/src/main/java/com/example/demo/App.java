package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

public class App {
    public static void main(String[] args) throws IOException {
     App app = new App();
     app.run();
    }
    private void run() throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/", new RequestHandler());
        httpServer.start();
        System.out.println("Server started. Listening on " + httpServer.getAddress());
    }
}
