package com.example.demo.presentation;

import com.example.demo.exception.NotFoundException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public final class RequestHandler implements HttpHandler {

    private final Map<String, RequestMethodHandler> handlers = new HashMap<>();
    int HTTP_OK = 200;

    public RequestHandler() {
        String KEY = "GET /";
        String KEY1 = "POST /calculations";
        String KEY2 = "GET /calculations";

        handlers.put(KEY, new GetHomeRequest());
        handlers.put(KEY1, new PostCalculationRequest());
        handlers.put(KEY2, new ListCalculationRequest());
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestContent = getRequestContent(exchange);

        String requestKey = getRequestKey(exchange);
        String responseContent = getRequestHandler(requestContent,
                requestKey);

        sendResponse(exchange, responseContent);
    }

    private String getRequestKey(HttpExchange exchange) {
        String method = exchange.getRequestMethod();
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        return method + " " + path;
    }

    private String getRequestHandler(
            String requestContent,
            String requestKey) throws IOException {

        RequestMethodHandler requestMethodHandler = handlers.get(requestKey);
        if (requestMethodHandler == null) {
            throw new NotFoundException("요청한 리소스를 찾을 수 없습니다.");
        }

        return requestMethodHandler.handler(requestContent);
    }

    private void sendResponse(HttpExchange exchange, String responseContent)
            throws IOException {
        byte[] bytes = responseContent.getBytes();

        exchange.sendResponseHeaders(HTTP_OK, bytes.length);

        exchange.getResponseBody().write(bytes);
    }

    private String getRequestContent(HttpExchange exchange) throws IOException {
        InputStream inputStream = exchange.getRequestBody();
        return new String(inputStream.readAllBytes());
    }
}
