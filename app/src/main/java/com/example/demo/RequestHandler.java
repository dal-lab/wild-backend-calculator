package com.example.demo;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = getRequestContent(exchange);

        requestContent = getRequestKey(exchange, requestContent);

        sendResponse(exchange, requestContent);
    }

    private String getRequestKey(HttpExchange exchange, String requestContent) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        requestContent = getRequestContent(requestContent, method, path);

        return requestContent;
    }

    private String getRequestContent(String requestContent, String method, String path) {
        if (method.equals("POST") && path.equals("/calculations")) {
            requestContent = "success";
        } else if (method.equals("GET") && path.equals("/calculations")) {
            requestContent = "success";
        }

        return requestContent;
    }

    private void sendResponse(HttpExchange exchange, String responseContent) throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(bytes);
        } catch (IOException e) {
            throw e;
        }
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
}
