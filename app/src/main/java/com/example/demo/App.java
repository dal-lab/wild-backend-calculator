package com.example.demo;

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
        httpServer.createContext("/", (exchange) -> {
            System.out.println("httpserver received request");
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
        });
        httpServer.start();
        System.out.println("Server started. Listening on " + httpServer.getAddress());
    }
}
