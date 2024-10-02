package com.example.demo.presentation;

public class PostCalculationRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        String[] values = content.split(" ");
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[2]);

        return String.valueOf(number1 + number2);
    }
}
