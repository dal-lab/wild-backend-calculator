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
        String key = method + " " + path;
        System.out.println("key: " + key);
        String response ="";

        if(key.equals("GET /")) {
            response = "Hello World\n";
        } else if(key.equals("POST /calculations")) {
            InputStream inputStream = exchange.getRequestBody();
            String requestBody = new String(inputStream.readAllBytes());
            String[] splitedRequestBody = requestBody.split(" ");
            System.out.println("requestBody: " + requestBody);
            int number1 = Integer.parseInt(splitedRequestBody[0]);
            int number2 = Integer.parseInt(splitedRequestBody[2]);
            String operation = splitedRequestBody[1];

            if(operation.equals("+")) {
                response = String.valueOf(number1 + number2);
            }
            else if(operation.equals("-")) {
                response = String.valueOf(number1 - number2);
            }
            else if(operation.equals("*")) {
                response = String.valueOf(number1 * number2);
            }
            else if(operation.equals("/")) {
                response = String.valueOf(number1 / number2);
            }
            else {
                response = "Error";
            }
        }
        response += "\n";
        exchange.sendResponseHeaders(200, response.length());
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(response.getBytes());
        }

    }
}
