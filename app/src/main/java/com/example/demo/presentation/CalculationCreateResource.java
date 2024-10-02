package com.example.demo.presentation;


import com.example.demo.application.Calculator;
import com.example.demo.application.OperatorKind;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CalculationCreateResource extends ResourceMethodHandler {
    public final static String KEY = "POST /calculations";
    public final Calculator calculator = new Calculator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String handle(String content) throws JsonProcessingException {
        try {
            CalculationRequestDto requestDto = objectMapper.readValue(content, CalculationRequestDto.class);
            OperatorKind operator = OperatorKind.fromSymbol(requestDto.getOperator());
            int result = calculator.calculate(requestDto.getNumber1(), requestDto.getNumber2(), operator);
            return objectMapper.writeValueAsString(
                    new CalculationResponseDto<>(
                            requestDto.getNumber1(),
                            requestDto.getNumber2(),
                            requestDto.getOperator(),
                            result
                    )
            );
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            e.printStackTrace();

            return "Error: Invalid input\n";
        }
    }
}
