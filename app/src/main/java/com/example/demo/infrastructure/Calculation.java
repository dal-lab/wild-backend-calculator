package com.example.demo.infrastructure;

public class Calculation {

    private int number1;
    private int number2;
    private String operation;
    private String result;

    public Calculation(int number1, int number2, String operation,
            String result) {
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

    public String getResult() {
        return result;
    }
}
