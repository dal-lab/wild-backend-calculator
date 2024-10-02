package com.example.demo.application;

import com.example.demo.exception.CalculatorArithmeticException;

public class OperatorDivide implements Operator {

    @Override
    public int calculate(int number1, int number2) {
        if (number2 == 0) {
            throw new CalculatorArithmeticException("나누기는 0으로 나눌 수 없습니다.");
        }

        return number1 / number2;
    }
}
