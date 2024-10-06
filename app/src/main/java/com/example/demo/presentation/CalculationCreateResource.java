package com.example.demo.presentation;

public class CalculationCreateResource extends ResourceMethodHandler {
    public final static String KEY = "POST /calculations";

    public String handle(String content) {
        String[] values = content.split(" ");
        int number1 = Integer.parseInt(values[0]);
        int number2 = Integer.parseInt(values[2]);
        String operator = values[1];
        System.out.println(operator);
        System.out.println(11111);
        int result = 0;

        if (operator.equals("+")){
            result = number1 + number2;
        }
        if (operator.equals("-")){
            result = number1 - number2;
        }
        if (operator.equals("*")){
            result = number1 * number2;
        }
        if (operator.equals("/")){
            result = number1 / number2;
        }

        return result + "\n";
    }
}
