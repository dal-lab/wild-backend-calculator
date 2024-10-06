package com.example.demo.application;

public class Calculator {
    public int calculate(int number1, int number2, String operator) {
        if (operator.equals("+")) {
            return number1 + number2;
        }
        if (operator.equals("-")) {
            return number1 - number2;
        }
        if (operator.equals("*")) {
            return number1 * number2;
        }
        if (operator.equals("/")) {
            return number1 / number2;
        }
        return 0;
    }
}
