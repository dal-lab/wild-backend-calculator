package com.example.demo.presentation;


import com.example.demo.application.Calculator;
import com.example.demo.application.OperatorKind;

public class CalculationCreateResource extends ResourceMethodHandler {
    public final static String KEY = "POST /calculations";
    public final Calculator calculator = new Calculator();


    public String handle(String content) {
        try {
            String[] splitedRequestBody = content.split(" ");
            int number1 = Integer.parseInt(splitedRequestBody[0]);
            int number2 = Integer.parseInt(splitedRequestBody[2]);
            OperatorKind operation = OperatorKind.fromSymbol(splitedRequestBody[1]);
            int responseContent = calculator.calculate(number1, number2, operation);

            return responseContent + "\n";
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            e.printStackTrace();

            return "Error: Invalid input\n";
        }
    }
}
