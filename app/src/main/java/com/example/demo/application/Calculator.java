package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.CalculationRepository;

import java.util.HashMap;
import java.util.List;

public class Calculator {
    private final HashMap<OperatorKind, Operator> operators = new HashMap<>();
    //    private final Map<String,Operator> operators = new HashMap<>();
    private final CalculationRepository calculationRepository = CalculationRepository.getInstance();

    public Calculator() {
        operators.put(OperatorKind.PLUS, new OperatorPlus());
        operators.put(OperatorKind.DIVIDE, new OperatorDivide());
        operators.put(OperatorKind.MINUS, new OperatorMinus());
        operators.put(OperatorKind.MULTIPLY, new OperatorMultiply());
    }

    public Calculation calculate(
            int number1, int number2, OperatorKind operator) {
        Operator op = operators.get(operator);
        int result = op.calculate(number1, number2);

        Calculation calculation = new Calculation(number1, number2, operator.getSymbol(), result);
        calculationRepository.add(calculation);

        return calculation;
    }

    public List<Calculation> getCalculations() {
        return calculationRepository.getCalculations();
    }
}
