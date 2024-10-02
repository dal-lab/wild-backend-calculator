package com.example.demo.application;

import java.util.HashMap;

public class Calculator {
    private final HashMap<OperatorKind, Operator> operators = new HashMap<>();

    public Calculator() {
        operators.put(OperatorKind.PLUS,new OperatorPlus());
        operators.put(OperatorKind.DIVIDE,new OperatorDivide());
        operators.put(OperatorKind.MINUS,new OperatorMinus());
        operators.put(OperatorKind.MULTIPLY,new OperatorMultiply());
    }

    public int calculate(int a, int b, OperatorKind operator) {
        Operator op = operators.get(operator);
        return op.calculate(a, b);
    }
}
