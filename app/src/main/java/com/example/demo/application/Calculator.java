package com.example.demo.application;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operator> operators = new HashMap<>();

    public Calculator() {
        operators.put("+", new OperatorPlus());
        operators.put("-", new OperatorMinus());
        operators.put("*", new OperatorMultiply());
        operators.put("/", new OperatorDivide());
    }

    public int calculate(int number1, int number2, String operatorSymbol) {
        if (operatorSymbol == null || !operators.containsKey(operatorSymbol)) {
            throw new IllegalArgumentException(
                    "Invalid operator: " + operatorSymbol);
        }

        Operator operator = operators.get(operatorSymbol);

        if (operator instanceof OperatorDivide && number2 == 0) {
            throw new ArithmeticException("나누기는 0으로 나눌 수 없습니다.");
        }

        return operator.calculate(number1, number2);
    }
}
