package com.example.demo.application;

public class Calculator {

    public int calculate(int number1, int number2, String operator) {
        switch (operator) {
            case "+":
                return OperatorPlus.calculate(number1, number2);
            case "-":
                return OperatorMinus.calculate(number1, number2);
            case "*":
                return OperatorMultiply.calculate(number1, number2);
            case "/":
                return OperatorDivide.calculate(number1, number2);
            default:
                throw new IllegalArgumentException(
                        "지원하지 않는 연산자입니다: " + operator
                );
        }
    }
}
