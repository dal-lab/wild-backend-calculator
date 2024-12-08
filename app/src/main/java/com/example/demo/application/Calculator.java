package com.example.demo.application;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operator> operators = new HashMap<>();

    public Calculator(){
        operators.put("+", new OperatorPlus());
        operators.put("-", new OperatorMinus());
        operators.put("*", new OperatorMultiply());
        operators.put("/", new OperatorDivide());
    }

    public int calculate(int number1, int number2, String operatorSymbol) {
        Operator operator = operators.get(operatorSymbol);
        return operator.calculate(number1, number2);
    }
}
