package com.example.demo.presentation;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements HttpHandler {
    private final Map<String, ResourceMethodHandler> methodHandlers = new HashMap<>();

    public RequestHandler() {
        methodHandlers.put(HomeGetResource.KEY, new HomeGetResource());
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

        sendResponseContent(exchange, responseContent);
    }

    public String getRequestKey(HttpExchange exchange) {
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
