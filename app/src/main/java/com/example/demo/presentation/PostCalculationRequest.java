package com.example.demo.presentation;

public class PostCalculationRequest implements RequestMethodHandler {

    @Override
    public String handler(String content) {
        String[] values = content.split(" ");
        String operator = String.valueOf(values[1]);
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[2]);

        switch (operator) {
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "*":
                return String.valueOf(number1 * number2);
            case "/":
                return String.valueOf(number1 / number2);
            default:
                throw new IllegalArgumentException(
                        "지원하지 않는 연산자입니다: " + operator);
        }
    }
}
