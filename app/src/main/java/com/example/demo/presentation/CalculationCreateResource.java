package com.example.demo.presentation;


public class CalculationCreateResource extends ResourceMethodHandler {
    public final static String KEY = "POST /calculations";

    public String handle(String content)  {
        String[] splitedRequestBody = content.split(" ");
        int number1 = Integer.parseInt(splitedRequestBody[0]);
        int number2 = Integer.parseInt(splitedRequestBody[2]);
        String operation = splitedRequestBody[1];
        String responseContent = "";

        if (operation.equals("+")) {
            responseContent = String.valueOf(number1 + number2);
        } else if (operation.equals("-")) {
            responseContent = String.valueOf(number1 - number2);
        } else if (operation.equals("*")) {
            responseContent = String.valueOf(number1 * number2);
        } else if (operation.equals("/")) {
            responseContent = String.valueOf(number1 / number2);
        } else {
            responseContent = "Error";
        }
        return responseContent;
    }
}
