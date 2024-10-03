package com.example.demo.application;

import com.example.demo.infrastructure.Calculation;
import com.example.demo.infrastructure.CalculationRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private CalculationRepository calculationRepository = CalculationRepository.getInstance();

    private final Map<String, Operator> operators = new HashMap<>();

    public Calculator() {
        operators.put("+", new OperatorPlus());
        operators.put("-", new OperatorMinus());
        operators.put("*", new OperatorMultiply());
        operators.put("/", new OperatorDivide());
    }

    public Calculation calculate(int number1, int number2,
            String operatorSymbol) {
        validateOperator(operatorSymbol);

        Operator operator = operators.get(operatorSymbol);

        int result = operator.calculate(number1, number2);

        Calculation calculation = Calculation.createCalculation(number1,
                number2, operatorSymbol, result);

        calculationRepository.add(calculation);

        return calculation;
    }

    private void validateOperator(String operatorSymbol) {
        if (operatorSymbol == null || !operators.containsKey(operatorSymbol)) {
            throw new IllegalArgumentException(
                    "Invalid operator: " + operatorSymbol);
        }
    }

    public List<Calculation> getCalculationList() {
        return calculationRepository.findAll();
    }
}
