package com.example.demo.presentation;

import com.example.demo.application.Calculator;

public class PostCalculationRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        String[] values = content.split(" ");
        String operator = String.valueOf(values[1]);
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[2]);

        Calculator calculator = new Calculator();
        int calculate = calculator.calculate(number1, number2, operator);

        return String.valueOf(calculate);
    }
}
