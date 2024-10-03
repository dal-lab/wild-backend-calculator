package com.example.demo.presentation;

public class GetHomeRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        return "hello World";
    }
}
