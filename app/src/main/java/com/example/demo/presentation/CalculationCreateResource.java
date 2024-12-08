package com.example.demo.presentation;

import com.example.demo.application.Calculator;

public class CalculationCreateResource extends ResourceMethodHandler {

    public final static String KEY = "POST /calculations";

    private final Calculator calculator = new Calculator();


    public String handle(String content){
        String[] values = content.split(" ");
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[2]);

        String operator = values[1];

        int result = calculator.calculate(number1, number2, operator);
        return result + "\n";
    }
}
