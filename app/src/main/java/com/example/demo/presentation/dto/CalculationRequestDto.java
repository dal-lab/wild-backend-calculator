package com.example.demo.presentation.dto;

public record CalculationRequestDto(
    int number1,
    int number2,
    String operator
){
    public int getNumber2() {
        return number2;
    }

    public int getNumber1() {
        return number1;
    }

    public String getOperator() {
        return operator;
    }
}
