package com.example.demo.presentation;

public class HomeGetResource extends ResourceMethodHandler {

    @Override
    public String key() {
        return "GET /";
    }

    @Override
    public String handle(String content) {
        return "Hello, world!\n";
    }
}
