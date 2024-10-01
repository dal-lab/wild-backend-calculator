package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String hello = "hello World";
        String requestKey = getRequestKey(exchange);

        sendResponse(exchange, hello);
    }

    private static void sendResponse(HttpExchange exchange, String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(bytes);
        }
    }

    private String getRequestKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        return method + " " + path;
    }
}
