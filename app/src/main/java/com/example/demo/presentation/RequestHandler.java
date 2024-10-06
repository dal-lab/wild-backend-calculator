package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        System.out.println(method + " " + path);

        String content = "";

        if (path.equals("/") && method.equals("GET")){
            content = "Hello, world!";
        }
        if (path.equals("/calculations") && method.equals("POST")){
            InputStream inputStream = exchange.getRequestBody();
            String input = new String(inputStream.readAllBytes());
            String[] values = input.split(" ");
            int number1 = Integer.parseInt(values[0]);
            int number2 = Integer.parseInt(values[2]);
            content = String.valueOf(number1 + number2);
        }
        if (content.isEmpty()) {
            exchange.sendResponseHeaders(404, -1);
            return;
        }
        content += "\n";

        byte[] bytes = content.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);

        try(OutputStream outputStream = exchange.getResponseBody()){
            outputStream.write(bytes);
        }
    }
}
