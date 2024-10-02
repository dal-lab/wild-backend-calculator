package com.example.demo.presentation;

import com.example.demo.application.Calculator;
import com.example.demo.presentation.dto.CalculationRequestDto;
import com.example.demo.presentation.dto.CalculationResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class PostCalculationRequest implements RequestMethodHandler {

    private final Calculator calculator = new Calculator();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String handler(String content) throws IOException {
        CalculationRequestDto calculationRequestDto = objectMapper.readValue(
                content,
                CalculationRequestDto.class
        );

        int calculate = calculator.calculate(
                calculationRequestDto.getNumber1(),
                calculationRequestDto.getNumber2(),
                calculationRequestDto.getOperator());

        return objectMapper.writeValueAsString(
                new CalculationResponseDto(
                        calculate
                )
        );
    }
}
