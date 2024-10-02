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
        String requestContent = getRequestContent(exchange);

        String processRequest = getProcessRequest(exchange, requestContent);

        sendResponse(exchange, processRequest);
    }

    private String getProcessRequest(HttpExchange exchange,
            String requestContent) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        requestContent = setRequestMethodAndPath(requestContent, method, path);

        return requestContent;
    }

    private String setRequestMethodAndPath(String requestContent, String method,
            String path) {
        if (method.equals("GET") && path.equals("/")) {
            return "hello world";
        }
        if (method.equals("POST") && path.equals("/calculations")) {
            return "success";
        }
        if (method.equals("GET") && path.equals("/calculations")) {
            return "success";
        }

        return "Not Fount Exception";
    }

    private void sendResponse(HttpExchange exchange, String responseContent)
            throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(200, bytes.length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(bytes);
        } catch (IOException e) {
            System.err.println("응답 전송 중 오류 발생: " + e.getMessage());
            throw e;
        }
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
}
