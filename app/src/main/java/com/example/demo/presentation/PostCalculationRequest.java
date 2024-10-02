package com.example.demo.presentation;

public class PostCalculationRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        return "success";
    }
}
