package com.example.demo.presentation;

import org.springframework.stereotype.Component;

@Component
public class HomeGetHandler extends ResourceMethodHandler {

    @Override
    public String handle(String content) {
        return "Hello, world!\n";
    }

    @Override
    public String key() {
        return "GET /";
    }
}
