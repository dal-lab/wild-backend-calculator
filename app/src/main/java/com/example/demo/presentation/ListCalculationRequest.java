package com.example.demo.presentation;

public class ListCalculationRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        return "list";
    }
}
