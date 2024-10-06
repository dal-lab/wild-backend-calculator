package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        System.out.println(method + " " + path);

        String content = "Hello, world!";
        byte[] bytes = content.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);

        try(OutputStream outputStream = exchange.getResponseBody()){
            outputStream.write(bytes);
        }
    }
}
