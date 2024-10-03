package com.example.demo.infrastructure;

public class Calculation {

    private int number1;
    private int number2;
    private String operation;
    private int result;

    public Calculation(int number1, int number2, String operation,
            int result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperation() {
        return operation;
    }

    public int getResult() {
        return result;
    }

    public static Calculation createCalculation(int number1, int number2,
            String operation,
            int result) {
        return new Calculation(number1, number2, operation, result);
    }
}
