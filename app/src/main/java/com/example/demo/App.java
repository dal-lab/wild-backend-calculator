package com.example.demo;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
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
        httpServer.createContext("/", (exchange) -> {
            System.out.println("httpserver received request");
            String method = exchange.getRequestMethod();
            URI uri = exchange.getRequestURI();
            String path = uri.getPath();
            System.out.println("method: " + method + " uri: " + uri + " path: " + path);

            String response = "Hello, World! \n";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(response.getBytes());
            }
        });
        httpServer.start();
        System.out.println("Server started. Listening on " + httpServer.getAddress());
    }
}
