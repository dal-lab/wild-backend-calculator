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

        String key = getRequestKey(exchange);
        String response ="";

        if(key.equals("GET /")) {
            response = "Hello World\n";
        } else if(key.equals("POST /calculations")) {
            String requestBody = getRequestContent(exchange);
            String[] splitedRequestBody = requestBody.split(" ");
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
        sendResponseContent(exchange, response);
    }
    public String getRequestKey(HttpExchange exchange){
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();
        return method + " " + path;
    }
    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
    private void sendResponseContent(HttpExchange exchange, String responseContent) throws IOException {
        exchange.sendResponseHeaders(200, responseContent.length());
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseContent.getBytes());
        }
    }
}
