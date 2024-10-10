package com.example.demo.presentation;

import org.springframework.stereotype.Component;

@Component
public class GetHomeRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        return "hello World";
    }

    @Override
    public String key() {
        return "GET /";
    }
}
