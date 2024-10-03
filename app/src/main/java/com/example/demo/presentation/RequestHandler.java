package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {
    private final Map<String, ResourceMethodHandler> methodHandlers = new HashMap<>();

    public RequestHandler() {
        methodHandlers.put(CalculationCreateResource.KEY, new CalculationCreateResource());
        methodHandlers.put(CalculationListResource.KEY, new CalculationListResource());

    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String requestKey = getRequestKey(exchange);
        if (!methodHandlers.containsKey(requestKey)) {
            System.out.println("methodHandlers에 " + requestKey + "가 없습니다.");
            exchange.sendResponseHeaders(404, -1);
            return;
        }

        ResourceMethodHandler methodHandler = methodHandlers.get(requestKey);

        String requestContent = getRequestContent(exchange);
        String responseContent = methodHandler.handle(requestContent);

        sendResponseContent(exchange, 200, "application/json", responseContent);
    }

    public String getRequestKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();
        String query = uri.getQuery();

        StringBuilder keyBuilder = new StringBuilder(method)
                .append(" ")
                .append(path);

        if (query != null && !query.isEmpty()) {
            keyBuilder.append("?").append(query);
        }

        return keyBuilder.toString();
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        final int MAX_BODY_SIZE = 1024 * 1024; // 1MB 제한
        InputStream inputStream = exchange.getRequestBody();
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int length;
        int totalBytes = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            totalBytes += length;
            if (totalBytes > MAX_BODY_SIZE) {
                throw new IOException("요청 본문이 너무 큽니다");
            }
            result.write(buffer, 0, length);
        }
        return result.toString("UTF-8");
    }

    private void sendResponseContent(HttpExchange exchange, int statusCode, String contentType, String responseContent) throws IOException {
        byte[] responseBytes = responseContent.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", contentType);
        exchange.sendResponseHeaders(statusCode, responseBytes.length);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseBytes);
        }

    }
}
